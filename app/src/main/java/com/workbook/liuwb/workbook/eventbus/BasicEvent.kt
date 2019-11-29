package com.workbook.liuwb.workbook.eventbus

class BasicEvent(builder: BasicEvent.Builder) {

    val code: Int
    val msg: String?
    val target: Any?

    override fun toString(): String {
        return "BasicEvent{" +
                "code=" + code +
                ", msg='" + msg + '\''.toString() +
                ", target=" + target +
                '}'.toString()
    }

    init {
        this.code = builder.code
        this.msg = builder.msg
        this.target = builder.target
    }

    class Builder {
        var code: Int = 0
        var msg: String? = null
        var target: Any? = null

        fun code(code: Int): Builder {
            this.code = code
            return this
        }

        fun msg(msg: String): Builder {
            this.msg = msg
            return this
        }

        fun target(target: Any): Builder {
            this.target = target
            return this
        }

        fun build(): BasicEvent {
            return BasicEvent(this)
        }
    }

    companion object {

        fun builder(): BasicEvent.Builder {
            return Builder()
        }
    }

}
