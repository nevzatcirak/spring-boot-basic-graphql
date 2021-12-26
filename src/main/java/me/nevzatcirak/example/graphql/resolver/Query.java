package me.nevzatcirak.example.graphql.resolver;

import java.util.List;

import graphql.kickstart.tools.GraphQLQueryResolver;
import me.nevzatcirak.example.graphql.dao.ApprovalProcessDao;
import me.nevzatcirak.example.graphql.model.ApprovalProcess;

public class Query implements GraphQLQueryResolver {
    private ApprovalProcessDao approvalProcessDao;

    public Query(ApprovalProcessDao approvalProcessDao) {
        this.approvalProcessDao = approvalProcessDao;
    }

    public List<ApprovalProcess> recentProcess(int count, int offset) {
        return approvalProcessDao.getRecentProcess(count, offset);
    }
}
