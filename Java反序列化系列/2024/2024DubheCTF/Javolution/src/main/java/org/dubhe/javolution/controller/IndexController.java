package org.dubhe.javolution.controller;

import org.dubhe.javolution.pool.PalDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;

@RestController
public class IndexController
{
    @RequestMapping("/")
    public String index()
    {
        return "Welcome to DubheCTF !";
    }

    @RequestMapping("/test")
    public String DbTest(@RequestParam(defaultValue = "dubhe") String username,
                         @RequestParam(defaultValue = "dubhe") String password)
    {
        PalDataSource dataSource = new PalDataSource();
        try {
            dataSource.getConnection(username, password);
        } catch (SQLException e) {
            return "Under construction...";
        }
        return "Just a connection test...";
    }
}