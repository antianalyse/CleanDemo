import io.temporal.client.WorkflowClient
import io.temporal.client.WorkflowOptions
import io.temporal.serviceclient.WorkflowServiceStubs
import kotlin.system.exitProcess

object InitiateHelloWorld {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        // 这个 gRPC 存根包装器与 Temporal 服务的本地 docker 实例对话
        val service = WorkflowServiceStubs.newLocalServiceStubs()
        // WorkflowClient 可用于启动、发送信号、查询、取消和终止工作流
        val client = WorkflowClient.newInstance(service)
        val options = WorkflowOptions.newBuilder().setTaskQueue(QueueShared.HELLO_WORLD_TASK_QUEUE.name).build()
        // WorkflowStubs 启用对方法的调用，就好像 Workflow 对象是本地的一样，但实际上执行的是 RPC
        val workflow: HelloWorldWorkflow = client.newWorkflowStub(HelloWorldWorkflow::class.java, options)
        // 同步执行工作流并等待响应
        val greeting: String = workflow.getGreeting("World")
        println(greeting)
        exitProcess(0)
    }
}