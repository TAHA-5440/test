// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines;
public final class JobCancellationException extends java.util.concurrent.CancellationException {
    public final transient gb.a1 g;

    public JobCancellationException(String p1, Throwable p2, gb.a1 p3)
    {
        super(p1);
        super.g = p3;
        if (p2 != null) {
            super.initCause(p2);
        }
        return;
    }

    public final boolean equals(Object p3)
    {
        if ((p3 != this) && ((!(p3 instanceof kotlinx.coroutines.JobCancellationException)) || ((!kotlin.jvm.internal.f.a(((kotlinx.coroutines.JobCancellationException) p3).getMessage(), this.getMessage())) || ((!kotlin.jvm.internal.f.a(((kotlinx.coroutines.JobCancellationException) p3).g, this.g)) || (!kotlin.jvm.internal.f.a(((kotlinx.coroutines.JobCancellationException) p3).getCause(), this.getCause())))))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final Throwable fillInStackTrace()
    {
        StackTraceElement[] v0_1 = new StackTraceElement[0];
        this.setStackTrace(v0_1);
        return this;
    }

    public final int hashCode()
    {
        int v0_2;
        int v0_0 = this.getMessage();
        v0_0.getClass();
        int v1_0 = ((this.g.hashCode() + (v0_0.hashCode() * 31)) * 31);
        int v0_1 = this.getCause();
        if (v0_1 == 0) {
            v0_2 = 0;
        } else {
            v0_2 = v0_1.hashCode();
        }
        return (v1_0 + v0_2);
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder();
        v0_1.append(super.toString());
        v0_1.append("; job=");
        v0_1.append(this.g);
        return v0_1.toString();
    }
}
