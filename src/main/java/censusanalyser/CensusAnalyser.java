package censusanalyser;

import com.google.gson.Gson;
import csvbulider.CSVBuliderException;
import csvbulider.CSVBuliderFactory;
import csvbulider.ICSVBulider;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.StreamSupport;

public class CensusAnalyser {

    List<CensusDAO> censusList = null;
    Map<String, CensusDAO> censusStateMap = null;

    public CensusAnalyser() {
        this.censusList = new ArrayList<CensusDAO>();
        this.censusStateMap = new HashMap<String, CensusDAO>();
    }

    public int loadIndiaCensusData(String... csvFilePath) throws CensusAnalyserException {
        censusStateMap =  new CensusLoader().loadCensusData(IndiaCensusCSV.class,csvFilePath);
        return censusStateMap.size();

    }


    public int loadUSCensusData(String... csvFilePath) throws CensusAnalyserException {

        censusStateMap =  new CensusLoader().loadCensusData(USCensusCSV.class,csvFilePath);
        return censusStateMap.size();
    }


    private <E> int getCount(Iterator<E> iterator) {
        Iterable<E> csvIterable = () -> iterator;
        int numofEateries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
        return numofEateries;

    }

    public String getStateWiseSortedCensusData() throws CensusAnalyserException {
        if (censusStateMap == null || censusStateMap.size() == 0) {
            throw new CensusAnalyserException("No census data", CensusAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        censusList.addAll(censusStateMap.values());
        Comparator<CensusDAO> censusCSVComparator = Comparator.comparing(census -> census.state);
        this.sort(censusCSVComparator);
        String sortedStateCensusJson = new Gson().toJson(this.censusList);
        return sortedStateCensusJson;

    }

    private void sort(Comparator<CensusDAO> censusCSVComparator) {
        for (int i = 0; i < censusList.size() - 1; i++) {
            for (int j = 0; j < censusList.size() - i - 1; j++) {
                CensusDAO censusCSV1 = censusList.get(j);
                CensusDAO censusCSV2 = censusList.get(j + 1);
                if (censusCSVComparator.compare(censusCSV1, censusCSV2) > 0) {
                    censusList.set(j, censusCSV2);
                    censusList.set(j + 1, censusCSV1);
                }
            }
        }
    }

    public String getstateCodeWiswSortedCensusData() throws CensusAnalyserException {
        if (censusStateMap == null || censusStateMap.size() == 0) {
            throw new CensusAnalyserException("No census data", CensusAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        censusList.addAll(censusStateMap.values());
        Comparator<CensusDAO> stateCSVComparator = Comparator.comparing(census -> census.stateCode);
        this.sortStateCode(stateCSVComparator);
        String sortedStateCensusJson = new Gson().toJson(this.censusList);
        return sortedStateCensusJson;

    }

    private void sortStateCode(Comparator<CensusDAO> stateCSVComparator) {
        for (int i = 0; i < censusList.size() - 1; i++) {
            for (int j = 0; j < censusList.size() - i - 1; j++) {
                CensusDAO censusCSV1 = censusList.get(j);
                CensusDAO censusCSV2 = censusList.get(j + 1);
                if (stateCSVComparator.compare(censusCSV1, censusCSV2) > 0) {
                    censusList.set(j, censusCSV2);
                    censusList.set(j + 1, censusCSV1);
                }
            }
        }
    }

    public String getStateCensusPopulationSortedData() throws CensusAnalyserException {
        if (censusStateMap == null || censusStateMap.size() == 0) {
            throw new CensusAnalyserException("No census data", CensusAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        censusList.addAll(censusStateMap.values());
        Comparator<CensusDAO> censusCSVComparator = Comparator.comparing(census -> census.population);
        this.sort(censusCSVComparator);
        String sortedStateCensusJson = new Gson().toJson(this.censusList);
        return sortedStateCensusJson;

    }

    public String getStateCensusDensitySortedData() throws CensusAnalyserException {
        if (censusStateMap == null || censusStateMap.size() == 0) {
            throw new CensusAnalyserException("No census data", CensusAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        censusList.addAll(censusStateMap.values());
        Comparator<CensusDAO> censusCSVComparator = Comparator.comparing(census -> census.populationDensity, Comparator.reverseOrder());
        this.sort(censusCSVComparator);
        String sortedStateCensusJson = new Gson().toJson(this.censusList);
        return sortedStateCensusJson;
    }

    public String getStateCensusAreaSortedData() throws CensusAnalyserException {
        if (censusStateMap == null || censusStateMap.size() == 0) {
            throw new CensusAnalyserException("No census Data", CensusAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        censusList.addAll(censusStateMap.values());
        Comparator<CensusDAO> csvComparator = Comparator.comparing(census -> census.totalArea, Comparator.reverseOrder());
        this.sort(csvComparator);
        String sortedStateCensusJson = new Gson().toJson(this.censusList);
        return sortedStateCensusJson;
    }

}
