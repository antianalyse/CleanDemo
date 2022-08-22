import io.temporal.client.WorkflowClient
import io.temporal.serviceclient.WorkflowServiceStubs
import io.temporal.worker.WorkerFactory

object HelloWorldWorker {
    @JvmStatic
    fun main(args: Array<String>) {
        // 这个 gRPC 存根包装器与 Temporal 服务的本地 docker 实例对话
        val service = WorkflowServiceStubs.newLocalServiceStubs()
        val client = WorkflowClient.newInstance(service)
        // 创建一个 Worker 工厂，可用于创建轮询特定任务队列的 Worker
        val factory = WorkerFactory.newInstance(client)
        val worker = factory.newWorker(QueueShared.HELLO_WORLD_TASK_QUEUE.name)
        // 此 Worker 承载 Workflow 和 Activity 实现
        // Workflow 是有状态的，因此您需要提供一个类型来创建实例
        worker.registerWorkflowImplementationTypes(HelloWorldWorkflowImpl::class.java)
        // Activities 是无状态且线程安全的，因此使用共享实例
        worker.registerActivitiesImplementations(FormatImpl())
        // 开始轮询任务队列
        factory.start()
    }
}