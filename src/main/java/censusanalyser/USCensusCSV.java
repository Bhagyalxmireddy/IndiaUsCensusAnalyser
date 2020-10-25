package censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class USCensusCSV {
    @CsvBindByName(column = "State", required = true)
    public String state;

    @CsvBindByName(column = "StateId", required = true)
    public String StateId;

    @CsvBindByName(column = "Population", required = true)
    public int Population;

    @CsvBindByName(column = "Total area", required = true)
    public double Totalarea;

    @CsvBindByName(column = "Population Density", required = true)
    public double PopulationDensity;

    @Override
    public String toString() {
        return "USCensusCSV{" +
                "State='" + state + '\'' +
                ", Population='" + Population + '\'' +
                ", Total area='" + Totalarea + '\'' +
                ", PopulationDensity='" + PopulationDensity + '\'' +
                '}';
    }
}
