package me.nevzatcirak.example.graphql.config;

import java.util.ArrayList;
import java.util.List;

import me.nevzatcirak.example.graphql.dao.ApproverDao;
import me.nevzatcirak.example.graphql.dao.ApprovalProcessDao;
import me.nevzatcirak.example.graphql.model.ApprovalProcess;
import me.nevzatcirak.example.graphql.model.Approver;
import me.nevzatcirak.example.graphql.resolver.ApproverResolver;
import me.nevzatcirak.example.graphql.resolver.Mutation;
import me.nevzatcirak.example.graphql.resolver.ApprovalProcessResolver;
import me.nevzatcirak.example.graphql.resolver.Query;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {
    @Bean
    public ApprovalProcessDao processDao() {
        List<ApprovalProcess> approvalProcesses = new ArrayList<>();
        for (int processId = 0; processId < 10; ++processId) {
            for (int approverId = 0; approverId < 10; ++approverId) {
                ApprovalProcess approvalProcess = new ApprovalProcess();
                approvalProcess.setId("ApprovalProcess_" + approverId +"_"+ processId);
                approvalProcess.setDocumentType("ExampleService");
                approvalProcess.setDocumentId(String.valueOf(processId + approverId));
                approvalProcesses.add(approvalProcess);
            }
        }
        return new ApprovalProcessDao(approvalProcesses);
    }

    @Bean
    public ApproverDao approverDao() {
        List<Approver> approvers = new ArrayList<>();
        for (int approverId = 0; approverId < 10; ++approverId) {
            Approver approver = new Approver();
            approver.setId("Approver_" + approverId);
            approver.setUsername("User_ " + approverId);
            approver.setSequenceNumber(approverId);
            approver.setStatus("WAITING");
            approver.setProcessId("ApprovalProcess_" + approverId +"_"+ approverId);
            approvers.add(approver);
        }
        return new ApproverDao(approvers);
    }

    @Bean
    public ApprovalProcessResolver processResolver(ApproverDao approverDao) {
        return new ApprovalProcessResolver(approverDao);
    }

    @Bean
    public ApproverResolver approverResolver(ApprovalProcessDao approvalProcessDao) {
        return new ApproverResolver(approvalProcessDao);
    }

    @Bean
    public Query query(ApprovalProcessDao approvalProcessDao) {
        return new Query(approvalProcessDao);
    }

    @Bean
    public Mutation mutation(ApprovalProcessDao approvalProcessDao) {
        return new Mutation(approvalProcessDao);
    }
}
