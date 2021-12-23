package com.example.banksystem.dao;

import com.example.banksystem.database.config.DatabaseConnection;
import com.example.banksystem.database.schema.tables.records.UserInfoRecord;
import com.example.banksystem.database.schema.tables.records.UserRecord;
import com.example.banksystem.model.User;
import com.example.banksystem.model.UserInfo;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.banksystem.database.schema.tables.User.USER;
import static com.example.banksystem.database.schema.tables.UserInfo.USER_INFO;

public class UserInfoDao implements Dao {

    @Override
    public Optional get(long id) {
        return Optional.empty();
    }

    @Override
    public List getAll() {
        List<UserInfo> userList = new ArrayList<>();

        try {
            Connection connection = DatabaseConnection.getConnection();
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);

            Result<UserInfoRecord> userRecords = context.selectFrom(USER_INFO)
                    .fetch();

            for (UserInfoRecord userRecord : userRecords)
                userList.add(new UserInfo(
                        userRecord.getValue(USER_INFO.ID),
                        userRecord.getValue(USER_INFO.BANK_ID),
                        userRecord.getValue(USER_INFO.SUM),
                        userRecord.getValue(USER_INFO.TERM),
                        userRecord.getValue(USER_INFO.LOAN)
                ));

        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }

        return userList;
    }

    @Override
    public void insert(Object o) {

    }

    @Override
    public void update(Object o, String[] params) {

    }

    @Override
    public void delete(Object o) {

    }
}
