package spring.certification.data.helper;

public class SqlQueries {

    public static final String HOLIDAYS_TABLE_NAME = "holidays";
    public static final String EMPLOYEES_TABLE_NAME = "employees";
    public static final String EMPLOYEE_ID_COLUMN = "emp_no";

    public static final String SQL_CREATE_TABLE_STATEMENT =
            "CREATE TABLE IF NOT EXISTS %s " +
                    "(" +
                    "id INT, " +
                    "name VARCHAR(50)" +
                    ")";
    public static final String SQL_TABLE_VERIFICATION_STATEMENT = "SELECT 1 FROM %s";
    public static final String SQL_DROP_TABLE_STATEMENT = "DROP TABLE %s IF EXISTS";

    public static final String SQL_COUNT_QUERY = "SELECT count(*) FROM %s";
    public static final String SQL_MAX_QUERY = "SELECT max(%s) FROM %s";

    public static final String SQL_INSERT_HOLIDAYS_STATEMENT = "INSERT INTO holidays (name) VALUES (%s)";
    public static final String SQL_INSERT_EMPLOYEE_STATEMENT = "INSERT INTO employees (emp_no, birth_date, first_name, last_name, gender, hire_date) VALUES (%s, %s, %s, %s, %s, %s)";

    public static final String QUOTE_WRAPPER = "'%s'";
}
