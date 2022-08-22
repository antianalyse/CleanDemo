import io.temporal.activity.ActivityOptions
import io.temporal.workflow.Workflow
import io.temporal.workflow.WorkflowInterface
import io.temporal.workflow.WorkflowMethod
import java.time.Duration


@WorkflowInterface
interface HelloWorldWorkflow {

    @WorkflowMethod
    fun getGreeting(name: String): String
}


class HelloWorldWorkflowImpl : HelloWorldWorkflow {
    private var options: ActivityOptions = ActivityOptions.newBuilder()
        .setScheduleToCloseTimeout(Duration.ofSeconds(2))
        .build()

    // ActivityStubs 启用对活动的调用，就好像它们是本地方法一样，但实际上执行的是 RPC
    private val format: Format = Workflow.newActivityStub(Format::class.java, options)

    override fun getGreeting(name: String): String {
        // 这是工作流的入口点
        // 如果有其他 Activity 方法，它们将在这里或从其他 Activity 中进行编排
        return format.composeGreeting(name)
    }
}