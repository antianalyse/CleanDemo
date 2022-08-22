package com.example.demo

import org.junit.Test

class Test {
    @Test
    fun test() {
        println(6696)
    }

}


class HelloWorldWorkflowTest {
//    @Rule
//    var testWorkflowRule: TestWorkflowRule = TestWorkflowRule.newBuilder()
//        .setWorkflowTypes(HelloWorldWorkflowImpl::class.java)
//        .setDoNotStart(true)
//        .build()
//
//    @Test
//    fun testGetGreeting() {
//        testWorkflowRule.getWorker().registerActivitiesImplementations(FormatImpl())
//        testWorkflowRule.getTestEnvironment().start()
//        val workflow: HelloWorldWorkflow = testWorkflowRule
//            .getWorkflowClient()
//            .newWorkflowStub(
//                HelloWorldWorkflow::class.java,
//                WorkflowOptions.newBuilder().setTaskQueue(testWorkflowRule.getTaskQueue()).build()
//            )
//        val greeting: String = workflow.getGreeting("John")
//        Assert.assertEquals("Hello John!", greeting)
//        testWorkflowRule.getTestEnvironment().shutdown()
//    }

//    @Test
//    fun testMockedGetGreeting() {
//        val formatActivities: Format = Mockito.mock(Format::class.java, Mockito.withSettings().withoutAnnotations())
//        Mockito.`when`(formatActivities.composeGreeting(ArgumentMatchers.anyString())).thenReturn("Hello World!")
//        testWorkflowRule.getWorker().registerActivitiesImplementations(formatActivities)
//        testWorkflowRule.getTestEnvironment().start()
//        val workflow: HelloWorldWorkflow = testWorkflowRule
//            .getWorkflowClient()
//            .newWorkflowStub(
//                HelloWorldWorkflow::class.java,
//                WorkflowOptions.newBuilder().setTaskQueue(testWorkflowRule.getTaskQueue()).build()
//            )
//        val greeting: String = workflow.getGreeting("World")
//        Assert.assertEquals("Hello World!", greeting)
//        testWorkflowRule.getTestEnvironment().shutdown()
//    }
}