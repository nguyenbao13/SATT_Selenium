package data_objects;

import common.Constant.Constant;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name="TicketProvider")
    public static Object[][] getDataFromDataProvider(){
        return new Object[][] {
                { Constant.DEPART_DATE, "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1" },
                { Constant.DEPART_DATE, "Đà Nẵng", "Nha Trang", "Soft bed with air conditioner", "1" },
                { Constant.DEPART_DATE, "Huế", "Nha Trang", "Soft bed with air conditioner", "1" },
                { Constant.DEPART_DATE, "Quảng Ngãi", "Nha Trang", "Soft bed with air conditioner", "1" },
                { Constant.DEPART_DATE, "Phan Thiết", "Nha Trang", "Soft bed with air conditioner", "1" },
                { Constant.DEPART_DATE, "Nha Trang", "Sài Gòn", "Soft bed with air conditioner", "1" }
        };
    }}
