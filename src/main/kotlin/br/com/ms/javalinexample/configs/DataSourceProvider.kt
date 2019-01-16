import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import java.util.*

object DataSourceProvider {

    val datasource = HikariDataSource(HikariConfig(properties()))

    private fun properties() = Properties().apply {
        put("jdbcUrl", System.getenv("MYSQL_URL"))
        put("dataSource.user", System.getenv("MYSQL_USER"))
        put("dataSource.password", System.getenv("MYSQL_PASSWORD"))
    }
}