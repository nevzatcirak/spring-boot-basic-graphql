package me.nevzatcirak.example.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import me.nevzatcirak.example.graphql.dao.ApprovalProcessDao;
import me.nevzatcirak.example.graphql.model.Approver;
import me.nevzatcirak.example.graphql.model.ApprovalProcess;

import java.util.List;

public class ApproverResolver implements GraphQLResolver<Approver> {
    private ApprovalProcessDao approvalProcessDao;

    public ApproverResolver(ApprovalProcessDao approvalProcessDao) {
        this.approvalProcessDao = approvalProcessDao;
    }

    public List<ApprovalProcess> getProcesses(Approver approver) {
        return approvalProcessDao.getApproverProcesses(approver.getId());
    }
}
