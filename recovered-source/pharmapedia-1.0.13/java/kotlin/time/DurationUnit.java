// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.time;
public final enum class DurationUnit extends java.lang.Enum {
    public static final enum kotlin.time.DurationUnit h;
    public static final enum kotlin.time.DurationUnit i;
    public static final enum kotlin.time.DurationUnit j;
    public static final enum kotlin.time.DurationUnit k;
    public static final enum kotlin.time.DurationUnit l;
    public static final enum kotlin.time.DurationUnit m;
    public static final synthetic kotlin.time.DurationUnit[] n;
    public final java.util.concurrent.TimeUnit g;

    static DurationUnit()
    {
        kotlin.time.DurationUnit[] v0_1 = new kotlin.time.DurationUnit("NANOSECONDS", 0, java.util.concurrent.TimeUnit.NANOSECONDS);
        kotlin.time.DurationUnit.h = v0_1;
        new kotlin.time.DurationUnit("MICROSECONDS", 1, java.util.concurrent.TimeUnit.MICROSECONDS);
        kotlin.time.DurationUnit.i = new kotlin.time.DurationUnit("MILLISECONDS", 2, java.util.concurrent.TimeUnit.MILLISECONDS);
        kotlin.time.DurationUnit.j = new kotlin.time.DurationUnit("SECONDS", 3, java.util.concurrent.TimeUnit.SECONDS);
        kotlin.time.DurationUnit.k = new kotlin.time.DurationUnit("MINUTES", 4, java.util.concurrent.TimeUnit.MINUTES);
        kotlin.time.DurationUnit.l = new kotlin.time.DurationUnit("HOURS", 5, java.util.concurrent.TimeUnit.HOURS);
        kotlin.time.DurationUnit v6_4 = new kotlin.time.DurationUnit("DAYS", 6, java.util.concurrent.TimeUnit.DAYS);
        kotlin.time.DurationUnit.m = v6_4;
        kotlin.time.DurationUnit[] v0_2 = new kotlin.time.DurationUnit[] {v0_1, v6_4});
        kotlin.time.DurationUnit.n = v0_2;
        kotlin.enums.a.a(v0_2);
        return;
    }

    public DurationUnit(String p1, int p2, java.util.concurrent.TimeUnit p3)
    {
        super(p1, p2);
        super.g = p3;
        return;
    }

    public static kotlin.time.DurationUnit valueOf(String p1)
    {
        return ((kotlin.time.DurationUnit) Enum.valueOf(kotlin.time.DurationUnit, p1));
    }

    public static kotlin.time.DurationUnit[] values()
    {
        return ((kotlin.time.DurationUnit[]) kotlin.time.DurationUnit.n.clone());
    }
}
