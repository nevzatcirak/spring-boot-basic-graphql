package me.nevzatcirak.example.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import me.nevzatcirak.example.graphql.dao.ApproverDao;
import me.nevzatcirak.example.graphql.model.ApprovalProcess;
import me.nevzatcirak.example.graphql.model.Approver;

import java.util.List;

public class ApprovalProcessResolver implements GraphQLResolver<ApprovalProcess> {
    private ApproverDao approverDao;

    public ApprovalProcessResolver(ApproverDao approverDao) {
        this.approverDao = approverDao;
    }

    public List<Approver> getApprovers(ApprovalProcess approvalProcess) {
        return approverDao.getApprovers(approvalProcess.getApproverIds());
    }
}
