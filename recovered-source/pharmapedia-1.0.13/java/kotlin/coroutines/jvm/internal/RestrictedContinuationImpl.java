// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.coroutines.jvm.internal;
public abstract class RestrictedContinuationImpl extends kotlin.coroutines.jvm.internal.BaseContinuationImpl {

    public RestrictedContinuationImpl(ka.c p2)
    {
        super(p2);
        if ((p2 != 0) && (p2.getContext() != kotlin.coroutines.EmptyCoroutineContext.g)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Coroutines with restricted suspension must have EmptyCoroutineContext");
            throw 0;
        } else {
            return;
        }
    }

    public final ka.g getContext()
    {
        return kotlin.coroutines.EmptyCoroutineContext.g;
    }
}
