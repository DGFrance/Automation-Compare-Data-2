package automation_verification.Bukalapak_test;

public class BL_Class {
	
	// Database Conection
		public static final String JDBC_DRIVER = "org.postgresql.Driver";
		public static final String DB_URL = "jdbc:postgresql://localhost:5432/transaction";
		public static final String UserName = "postgres";
		public static final String Password = "postgress";

		// Element can be used to find the data for automation
		public static final String webUrl = "Bukalapak.com/transaction"; 
		public static final String id = "TRX_ID" ;
		public static final String address = "ADDRESS_SHIP";
		public static final String date = "DATE_ORDER";
		public static final String seller = "SELLER_NAME";
		public static final String delivery = "DELIVERY_SERVICE";

		// SQL method
		public static final String sql = "SELECT * FROM public.user where id = 01023A9AC";
}
