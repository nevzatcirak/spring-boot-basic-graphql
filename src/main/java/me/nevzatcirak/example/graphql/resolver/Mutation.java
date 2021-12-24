package me.nevzatcirak.example.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import me.nevzatcirak.example.graphql.dao.ApprovalProcessDao;
import me.nevzatcirak.example.graphql.model.ApprovalProcess;

import java.util.UUID;

public class Mutation implements GraphQLMutationResolver {
    private ApprovalProcessDao approvalProcessDao;

    public Mutation(ApprovalProcessDao approvalProcessDao) {
        this.approvalProcessDao = approvalProcessDao;
    }

    public ApprovalProcess saveProcess(String documentType, String documentId, String creator) {
        ApprovalProcess approvalProcess = new ApprovalProcess();
        approvalProcess.setId(UUID.randomUUID().toString());
        approvalProcess.setDocumentType(documentType);
        approvalProcess.setDocumentId(documentId);
        approvalProcess.setCreator(creator);
        approvalProcess.setStatus("WAITING");
        return approvalProcessDao.saveProcess(approvalProcess);
    }
}
