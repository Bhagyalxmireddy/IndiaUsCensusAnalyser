package csvbulider;

public class CSVBuliderFactory {
    public static ICSVBulider createCSVBulider() {

        return  new csvbulider.OpenCSVBulider<>();
    }
}
