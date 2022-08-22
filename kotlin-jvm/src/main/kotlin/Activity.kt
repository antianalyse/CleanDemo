import io.temporal.activity.ActivityInterface
import io.temporal.activity.ActivityMethod

@ActivityInterface
interface Format {

    @ActivityMethod
    fun composeGreeting(name: String): String
}

class FormatImpl : Format {

    override fun composeGreeting(name: String): String {
        return "Hello $name!"
    }
}