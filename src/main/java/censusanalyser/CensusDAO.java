package censusanalyser;

public class CensusDAO {
    public String state;
    public String stateCode;
    public  int population;
    public  double totalArea;
    public  double populationDensity;


    public CensusDAO(IndiaCensusCSV indiaCensusCSV) {
        state = indiaCensusCSV.state;
        totalArea = indiaCensusCSV.totalArea;
        populationDensity = indiaCensusCSV.populationDensity;
        population = indiaCensusCSV.population;
    }
    public CensusDAO(IndiaStateCodeCSV indiaStateCodeCSV){
        stateCode = indiaStateCodeCSV.stateCode;

    }

    public CensusDAO(USCensusCSV censusCSV) {
        state = censusCSV.state;
        stateCode = censusCSV.StateId;
        population = censusCSV.Population;
        populationDensity = censusCSV.PopulationDensity;
        totalArea = censusCSV.Totalarea;
    }
}
