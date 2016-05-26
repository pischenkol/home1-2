package SQL;

public class SQL {
    public static final String SQL_USE_DB = "USE test";
    public static final String SQL_CREATE_PRODUCTS = "CREATE TABLE IF NOT EXISTS products("  + "(MFR_ID CHAR(3) NOT NULL, PRODUCT_ID CHAR(5) NOT NULL, DESCRIPTION VARCHAR(20) NOT NULL, PRICE DECIMAL(9,2) NOT NULL, QTY_ON_HAND INTEGER NOT NULL, PRIMARY KEY (MFR_ID, PRODUCT_ID))";
    public static final String SQL_CREATE_OFFICES = "CREATE TABLE IF NOT EXISTS OFFICES (" +
            "(OFFICE INTEGER NOT NULL,\n" +
            "        CITY VARCHAR(15) NOT NULL,\n" +
            "      REGION VARCHAR(10) NOT NULL,\n" +
            "         MGR INTEGER,\n" +
            "      TARGET DECIMAL(9,2),\n" +
            "       SALES DECIMAL(9,2) NOT NULL,\n" +
            " PRIMARY KEY (OFFICE))";
    public static final String SQL_CREATE_SALESREPS = "CREATE TABLE IF NOT EXISTS SALESREPS(" + "   (EMPL_NUM INTEGER NOT NULL,\n" +
            "             CHECK (EMPL_NUM BETWEEN 101 AND 199),\n" +
            "        NAME VARCHAR(15) NOT NULL,\n" +
            "         AGE INTEGER,\n" +
            "  REP_OFFICE INTEGER,\n" +
            "       TITLE VARCHAR(10),\n" +
            "   HIRE_DATE DATE NOT NULL,\n" +
            "     MANAGER INTEGER,\n" +
            "       QUOTA DECIMAL(9,2),\n" +
            "       SALES DECIMAL(9,2) NOT NULL,\n" +
            " PRIMARY KEY (EMPL_NUM),\n" +
            " FOREIGN KEY (MANAGER)\n" +
            "  REFERENCES SALESREPS(EMPL_NUM)\n" +
            "  ON DELETE SET NULL,\n" +
            " FOREIGN KEY WORKSIN (REP_OFFICE)  \n" +
            "  REFERENCES OFFICES(OFFICE)\n" +
            "  ON DELETE SET NULL)";
    public static final String SQL_CREATE_CUSTOMERS = "CREATE TABLE IF NOT EXISTS CUSTOMERS(" + "  (CUST_NUM INTEGER    NOT NULL,\n" +
            "    COMPANY  VARCHAR(20) NOT NULL,\n" +
            "    CUST_REP INTEGER,\n" +
            "    CREDIT_LIMIT DECIMAL(9,2),\n" +
            " PRIMARY KEY (CUST_NUM),\n" +
            " FOREIGN KEY HASREP (CUST_REP)\n" +
            "  REFERENCES SALESREPS(EMPL_NUM)\n" +
            "   ON DELETE SET NULL)";
    public static final String SQL_CREATE_ORDERS = "CREATE TABLE IF NOT EXISTS ORDERS(" + " (ORDER_NUM INTEGER NOT NULL,\n" +
            "             CHECK (ORDER_NUM > 100000),\n" +
            "  ORDER_DATE DATE NOT NULL,\n" +
            "        CUST INTEGER NOT NULL,\n" +
            "         REP INTEGER,\n" +
            "         MFR CHAR(3) NOT NULL,\n" +
            "     PRODUCT CHAR(5) NOT NULL,\n" +
            "         QTY INTEGER NOT NULL,\n" +
            "      AMOUNT DECIMAL(9,2) NOT NULL,\n" +
            " PRIMARY KEY (ORDER_NUM),\n" +
            " FOREIGN KEY PLACEDBY (CUST)\n" +
            "  REFERENCES CUSTOMERS(CUST_NUM)\n" +
            "   ON DELETE CASCADE,\n" +
            " FOREIGN KEY TAKENBY (REP)\n" +
            "  REFERENCES SALESREPS(EMPL_NUM)\n" +
            "   ON DELETE SET NULL,\n" +
            " FOREIGN KEY ISFOR (MFR, PRODUCT)\n" +
            "  REFERENCES PRODUCTS(MFR_ID, PRODUCT_ID)\n" +
            "   ON DELETE RESTRICT)";


    public static final String SQL_SELECT_ORDERS = "SELECT NAME, AGE FROM SALESREPS, OFFICES ";

    public static final String SQL_INSERT_IN_GROUP = "INSERT INTO groups(group_number,department) VALUES (?, ?)";
    public static final String SQL_INSERT_IN_STUDENTS = "INSERT INTO students(name,surname,enrolment_date,group_id) VALUES (?,?,?,?)";
    public static final String SQL_SELECT_BY_GROUP_NUMBER = "SELECT * FROM groups WHERE group_number = ?";
    public static final String SQL_SELECT_STUDENT_BY_ID = "SELECT * FROM  students WHERE id = ?";
    public static final String SQL_SELECT_ALL_STUDENTS = "SELECT * FROM students";
    public static final String SQL_SELECT_ALL_GROUPS = "SELECT * FROM groups";
    public static final String SQL_SHOW_TABLES = "SHOW TABLES";
    public static final String SQL_UPDATE_STUDENT_BY_ID = "UPDATE students SET name = ?, surname = ?,enrolment_date=?,group_id=? WHERE id = ?";
    public static final String SQL_DELETE_STUDENT = "DELETE FROM students where name = ? and surname = ? and enrolment_date=? and group_id=?";
    public static final String SQL_SELECT_STUDENT = "SELECT * FROM  students WHERE name = ? and surname = ? and enrolment_date=?";
    public static final String SQL_UPDATE_GROUP_BY_ID = "UPDATE groups SET group_id=? department=? WHERE id = ? department = ?";
    public static final String SQL_DELETE_GROUP = "DELETE FROM groups where  group_id=?";
    public static final String SQL_SELECT_GROUP = "SELECT * FROM  groups WHERE group_id=?";
}
