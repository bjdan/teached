package com.teachedapp.respository;

import com.teachedapp.dao.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findAccountByLogin(String login);

    @Query(value = "SELECT (CASE\n" +
            "\tWHEN teacher_id IS NOT NULL THEN 'ROLE_TEACHER'\n" +
            "\tWHEN student_id IS NOT NULL THEN 'ROLE_STUDENT'\n" +
            "\tWHEN administrator_id IS NOT NULL THEN 'ROLE_ADMINISTRATOR'\n" +
            "\tELSE 'ROLE_OTHER'\n" +
            "\tEND) as role\n" +
            "FROM account\n" +
            "\tLEFT JOIN student ON account_id = student_id\n" +
            "\tLEFT JOIN teacher ON account_id = teacher_id\n" +
            "\tLEFT JOIN administrator ON account_id = administrator_id\n" +
            "WHERE account_id = (:accountId)", nativeQuery = true)
    String findRoleByAccountId(@Param("accountId") Integer accountId);
}