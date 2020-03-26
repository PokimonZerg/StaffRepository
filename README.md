# StaffRepository

Запуск сервера с MySQL с тестовой базой данных
`docker run -d --name mysql-employees -p 3306:3306 -e MYSQL_ROOT_PASSWORD=college genschsa/mysql-employees:latest`

Далее как сказано в задаче, настраиваем Connection Pool в Tomcat   
server.xml  
`<Resource name="jdbc/employees"
                 global="jdbc/employees"
                 factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"
                 auth="Container"
                 type="javax.sql.DataSource"             
                 username="root"
                 password="college"
                 driverClassName="com.mysql.jdbc.Driver"
                 description="JCG Example MySQL database."
                 url="jdbc:mysql://192.168.2.71:3306/employees"
                 maxTotal="10"
                 maxIdle="10"
                 maxWaitMillis="10000"
                 removeAbandonedTimeout="300"           
                 defaultAutoCommit="true" />`

context.xml  
`   <ResourceLink
     name="jdbc/employees"
     global="jdbc/employees"
     type="javax.sql.DataSource"/>`

Положить JDBC driver для MySQL в папку tomcat/lib

Далее после deploy приложения на сервер приложений tomcat, зайти по адресу /staff/
