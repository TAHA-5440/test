// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.jvm.internal;
public abstract class f {
    public static final Object[] a;

    static f()
    {
        Object[] v0_1 = new Object[0];
        kotlin.jvm.internal.f.a = v0_1;
        return;
    }

    public static boolean a(Object p0, Object p1)
    {
        if (p0 != 0) {
            return p0.equals(p1);
        } else {
            if (p1 != null) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static String b(String p1)
    {
        String v0_0 = p1.hashCode();
        switch (v0_0) {
            case -2061550653:
                if (p1.equals("kotlin.jvm.internal.DoubleCompanionObject")) {
                    return "kotlin.Double.Companion";
                } else {
                }
            case -2056817302:
                if (p1.equals("java.lang.Integer")) {
                    return "kotlin.Int";
                } else {
                }
            case -2034166429:
                if (p1.equals("java.lang.Cloneable")) {
                    return "kotlin.Cloneable";
                } else {
                }
            case -1979556166:
                if (p1.equals("java.lang.annotation.Annotation")) {
                    return "kotlin.Annotation";
                } else {
                }
            case -1571515090:
                if (p1.equals("java.lang.Comparable")) {
                    return "kotlin.Comparable";
                } else {
                }
            case -1383349348:
                if (p1.equals("java.util.Map")) {
                    return "kotlin.collections.Map";
                } else {
                }
            case -1383343454:
                if (p1.equals("java.util.Set")) {
                    return "kotlin.collections.Set";
                } else {
                }
            case -1325958191:
                if (p1.equals("double")) {
                    return "kotlin.Double";
                } else {
                }
            case -1182275604:
                if (p1.equals("kotlin.jvm.internal.ByteCompanionObject")) {
                    return "kotlin.Byte.Companion";
                } else {
                }
            case -1062240117:
                if (p1.equals("java.lang.CharSequence")) {
                    return "kotlin.CharSequence";
                } else {
                }
            case -688322466:
                if (p1.equals("java.util.Collection")) {
                    return "kotlin.collections.Collection";
                } else {
                }
            case -527879800:
                if (p1.equals("java.lang.Float")) {
                    return "kotlin.Float";
                } else {
                }
            case -515992664:
                if (p1.equals("java.lang.Short")) {
                    return "kotlin.Short";
                } else {
                }
            case -246476834:
                if (p1.equals("kotlin.jvm.internal.CharCompanionObject")) {
                    return "kotlin.Char.Companion";
                } else {
                }
            case -207262728:
                if (p1.equals("kotlin.jvm.internal.LongCompanionObject")) {
                    return "kotlin.Long.Companion";
                } else {
                }
            case -165139126:
                if (p1.equals("java.util.Map$Entry")) {
                    return "kotlin.collections.Map.Entry";
                } else {
                }
            case 104431:
                if (p1.equals("int")) {
                    return "kotlin.Int";
                } else {
                }
            case 3039496:
                if (p1.equals("byte")) {
                    return "kotlin.Byte";
                } else {
                }
            case 3052374:
                if (p1.equals("char")) {
                    return "kotlin.Char";
                } else {
                }
            case 3327612:
                if (p1.equals("long")) {
                    return "kotlin.Long";
                } else {
                }
            case 64711720:
                if (p1.equals("boolean")) {
                    return "kotlin.Boolean";
                } else {
                }
            case 65821278:
                if (p1.equals("java.util.List")) {
                    return "kotlin.collections.List";
                } else {
                }
            case 77230534:
                if (p1.equals("kotlin.jvm.internal.ShortCompanionObject")) {
                    return "kotlin.Short.Companion";
                } else {
                }
            case 97526364:
                if (p1.equals("float")) {
                    return "kotlin.Float";
                } else {
                }
            case 109413500:
                if (p1.equals("short")) {
                    return "kotlin.Short";
                } else {
                }
            case 155276373:
                if (p1.equals("java.lang.Character")) {
                    return "kotlin.Char";
                } else {
                }
            case 226173651:
                if (p1.equals("kotlin.jvm.internal.EnumCompanionObject")) {
                    return "kotlin.Enum.Companion";
                } else {
                }
            case 344809556:
                if (p1.equals("java.lang.Boolean")) {
                    return "kotlin.Boolean";
                } else {
                }
            case 398507100:
                if (p1.equals("java.lang.Byte")) {
                    return "kotlin.Byte";
                } else {
                }
            case 398585941:
                if (p1.equals("java.lang.Enum")) {
                    return "kotlin.Enum";
                } else {
                }
            case 398795216:
                if (p1.equals("java.lang.Long")) {
                    return "kotlin.Long";
                } else {
                }
            case 482629606:
                if (p1.equals("kotlin.jvm.internal.FloatCompanionObject")) {
                    return "kotlin.Float.Companion";
                } else {
                }
            case 499831342:
                if (p1.equals("java.util.Iterator")) {
                    return "kotlin.collections.Iterator";
                } else {
                }
            case 577341676:
                if (p1.equals("java.util.ListIterator")) {
                    return "kotlin.collections.ListIterator";
                } else {
                }
            case 599019395:
                if (p1.equals("kotlin.jvm.internal.StringCompanionObject")) {
                    return "kotlin.String.Companion";
                } else {
                }
            case 761287205:
                if (p1.equals("java.lang.Double")) {
                    return "kotlin.Double";
                } else {
                }
            case 1052881309:
                if (p1.equals("java.lang.Number")) {
                    return "kotlin.Number";
                } else {
                }
            case 1063877011:
                if (p1.equals("java.lang.Object")) {
                    return "kotlin.Any";
                } else {
                }
            case 1195259493:
                if (p1.equals("java.lang.String")) {
                    return "kotlin.String";
                } else {
                }
            case 1275614662:
                if (p1.equals("java.lang.Iterable")) {
                    return "kotlin.collections.Iterable";
                } else {
                }
            case 1383693018:
                if (p1.equals("kotlin.jvm.internal.BooleanCompanionObject")) {
                    return "kotlin.Boolean.Companion";
                } else {
                }
            case 1630335596:
                if (p1.equals("java.lang.Throwable")) {
                    return "kotlin.Throwable";
                } else {
                }
            case 1877171123:
                if (p1.equals("kotlin.jvm.internal.IntCompanionObject")) {
                    return "kotlin.Int.Companion";
                } else {
                }
            default:
                switch (v0_0) {
                    case -1811142716:
                        if (p1.equals("kotlin.jvm.functions.Function10")) {
                            return "kotlin.Function10";
                        } else {
                        }
                    case -1811142715:
                        if (p1.equals("kotlin.jvm.functions.Function11")) {
                            return "kotlin.Function11";
                        } else {
                        }
                    case -1811142714:
                        if (p1.equals("kotlin.jvm.functions.Function12")) {
                            return "kotlin.Function12";
                        } else {
                        }
                    case -1811142713:
                        if (p1.equals("kotlin.jvm.functions.Function13")) {
                            return "kotlin.Function13";
                        } else {
                        }
                    case -1811142712:
                        if (p1.equals("kotlin.jvm.functions.Function14")) {
                            return "kotlin.Function14";
                        } else {
                        }
                    case -1811142711:
                        if (p1.equals("kotlin.jvm.functions.Function15")) {
                            return "kotlin.Function15";
                        } else {
                        }
                    case -1811142710:
                        if (p1.equals("kotlin.jvm.functions.Function16")) {
                            return "kotlin.Function16";
                        } else {
                        }
                    case -1811142709:
                        if (p1.equals("kotlin.jvm.functions.Function17")) {
                            return "kotlin.Function17";
                        } else {
                        }
                    case -1811142708:
                        if (p1.equals("kotlin.jvm.functions.Function18")) {
                            return "kotlin.Function18";
                        } else {
                        }
                    case -1811142707:
                        if (p1.equals("kotlin.jvm.functions.Function19")) {
                            return "kotlin.Function19";
                        } else {
                        }
                    default:
                        switch (v0_0) {
                            case -1811142685:
                                if (p1.equals("kotlin.jvm.functions.Function20")) {
                                    return "kotlin.Function20";
                                } else {
                                }
                            case -1811142684:
                                if (p1.equals("kotlin.jvm.functions.Function21")) {
                                    return "kotlin.Function21";
                                } else {
                                }
                            case -1811142683:
                                if (p1.equals("kotlin.jvm.functions.Function22")) {
                                    return "kotlin.Function22";
                                } else {
                                }
                            default:
                                switch (v0_0) {
                                    case 80123371:
                                        if (p1.equals("kotlin.jvm.functions.Function0")) {
                                            return "kotlin.Function0";
                                        } else {
                                        }
                                    case 80123372:
                                        if (p1.equals("kotlin.jvm.functions.Function1")) {
                                            return "kotlin.Function1";
                                        } else {
                                        }
                                    case 80123373:
                                        if (p1.equals("kotlin.jvm.functions.Function2")) {
                                            return "kotlin.Function2";
                                        } else {
                                        }
                                    case 80123374:
                                        if (p1.equals("kotlin.jvm.functions.Function3")) {
                                            return "kotlin.Function3";
                                        } else {
                                        }
                                    case 80123375:
                                        if (p1.equals("kotlin.jvm.functions.Function4")) {
                                            return "kotlin.Function4";
                                        } else {
                                        }
                                    case 80123376:
                                        if (p1.equals("kotlin.jvm.functions.Function5")) {
                                            return "kotlin.Function5";
                                        } else {
                                        }
                                    case 80123377:
                                        if (p1.equals("kotlin.jvm.functions.Function6")) {
                                            return "kotlin.Function6";
                                        } else {
                                        }
                                    case 80123378:
                                        if (p1.equals("kotlin.jvm.functions.Function7")) {
                                            return "kotlin.Function7";
                                        } else {
                                        }
                                    case 80123379:
                                        if (p1.equals("kotlin.jvm.functions.Function8")) {
                                            return "kotlin.Function8";
                                        } else {
                                        }
                                    case 80123380:
                                        if (p1.equals("kotlin.jvm.functions.Function9")) {
                                            return "kotlin.Function9";
                                        } else {
                                        }
                                    default:
                                }
                        }
                }
        }
        return 0;
    }

    public static int c(int p0, int p1)
    {
        if (p0 >= p1) {
            if (p0 != p1) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }

    public static int d(long p0, long p2)
    {
        int v0_1 = p0 cmp p2;
        if (v0_1 >= 0) {
            if (v0_1 != 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }

    public static void e(RuntimeException p5, String p6)
    {
        StackTraceElement[] v0 = p5.getStackTrace();
        int v1 = v0.length;
        int v2_0 = -1;
        int v3 = 0;
        while (v3 < v1) {
            if (p6.equals(v0[v3].getClassName())) {
                v2_0 = v3;
            }
            v3++;
        }
        p5.setStackTrace(((StackTraceElement[]) java.util.Arrays.copyOfRange(v0, (v2_0 + 1), v1)));
        return;
    }

    public static String f(String p1)
    {
        String v0_0 = p1.hashCode();
        switch (v0_0) {
            case -2061550653:
                if (p1.equals("kotlin.jvm.internal.DoubleCompanionObject")) {
                    return "Companion";
                } else {
                }
            case -2056817302:
                if (p1.equals("java.lang.Integer")) {
                    return "Int";
                } else {
                }
            case -2034166429:
                if (p1.equals("java.lang.Cloneable")) {
                    return "Cloneable";
                } else {
                }
            case -1979556166:
                if (p1.equals("java.lang.annotation.Annotation")) {
                    return "Annotation";
                } else {
                }
            case -1571515090:
                if (p1.equals("java.lang.Comparable")) {
                    return "Comparable";
                } else {
                }
            case -1383349348:
                if (p1.equals("java.util.Map")) {
                    return "Map";
                } else {
                }
            case -1383343454:
                if (p1.equals("java.util.Set")) {
                    return "Set";
                } else {
                }
            case -1325958191:
                if (p1.equals("double")) {
                    return "Double";
                } else {
                }
            case -1182275604:
                if (p1.equals("kotlin.jvm.internal.ByteCompanionObject")) {
                    return "Companion";
                } else {
                }
            case -1062240117:
                if (p1.equals("java.lang.CharSequence")) {
                    return "CharSequence";
                } else {
                }
            case -688322466:
                if (p1.equals("java.util.Collection")) {
                    return "Collection";
                } else {
                }
            case -527879800:
                if (p1.equals("java.lang.Float")) {
                    return "Float";
                } else {
                }
            case -515992664:
                if (p1.equals("java.lang.Short")) {
                    return "Short";
                } else {
                }
            case -246476834:
                if (p1.equals("kotlin.jvm.internal.CharCompanionObject")) {
                    return "Companion";
                } else {
                }
            case -207262728:
                if (p1.equals("kotlin.jvm.internal.LongCompanionObject")) {
                    return "Companion";
                } else {
                }
            case -165139126:
                if (p1.equals("java.util.Map$Entry")) {
                    return "Entry";
                } else {
                }
            case 104431:
                if (p1.equals("int")) {
                    return "Int";
                } else {
                }
            case 3039496:
                if (p1.equals("byte")) {
                    return "Byte";
                } else {
                }
            case 3052374:
                if (p1.equals("char")) {
                    return "Char";
                } else {
                }
            case 3327612:
                if (p1.equals("long")) {
                    return "Long";
                } else {
                }
            case 64711720:
                if (p1.equals("boolean")) {
                    return "Boolean";
                } else {
                }
            case 65821278:
                if (p1.equals("java.util.List")) {
                    return "List";
                } else {
                }
            case 77230534:
                if (p1.equals("kotlin.jvm.internal.ShortCompanionObject")) {
                    return "Companion";
                } else {
                }
            case 97526364:
                if (p1.equals("float")) {
                    return "Float";
                } else {
                }
            case 109413500:
                if (p1.equals("short")) {
                    return "Short";
                } else {
                }
            case 155276373:
                if (p1.equals("java.lang.Character")) {
                    return "Char";
                } else {
                }
            case 226173651:
                if (p1.equals("kotlin.jvm.internal.EnumCompanionObject")) {
                    return "Companion";
                } else {
                }
            case 344809556:
                if (p1.equals("java.lang.Boolean")) {
                    return "Boolean";
                } else {
                }
            case 398507100:
                if (p1.equals("java.lang.Byte")) {
                    return "Byte";
                } else {
                }
            case 398585941:
                if (p1.equals("java.lang.Enum")) {
                    return "Enum";
                } else {
                }
            case 398795216:
                if (p1.equals("java.lang.Long")) {
                    return "Long";
                } else {
                }
            case 482629606:
                if (p1.equals("kotlin.jvm.internal.FloatCompanionObject")) {
                    return "Companion";
                } else {
                }
            case 499831342:
                if (p1.equals("java.util.Iterator")) {
                    return "Iterator";
                } else {
                }
            case 577341676:
                if (p1.equals("java.util.ListIterator")) {
                    return "ListIterator";
                } else {
                }
            case 599019395:
                if (p1.equals("kotlin.jvm.internal.StringCompanionObject")) {
                    return "Companion";
                } else {
                }
            case 761287205:
                if (p1.equals("java.lang.Double")) {
                    return "Double";
                } else {
                }
            case 1052881309:
                if (p1.equals("java.lang.Number")) {
                    return "Number";
                } else {
                }
            case 1063877011:
                if (p1.equals("java.lang.Object")) {
                    return "Any";
                } else {
                }
            case 1195259493:
                if (p1.equals("java.lang.String")) {
                    return "String";
                } else {
                }
            case 1275614662:
                if (p1.equals("java.lang.Iterable")) {
                    return "Iterable";
                } else {
                }
            case 1383693018:
                if (p1.equals("kotlin.jvm.internal.BooleanCompanionObject")) {
                    return "Companion";
                } else {
                }
            case 1630335596:
                if (p1.equals("java.lang.Throwable")) {
                    return "Throwable";
                } else {
                }
            case 1877171123:
                if (p1.equals("kotlin.jvm.internal.IntCompanionObject")) {
                    return "Companion";
                } else {
                }
            default:
                switch (v0_0) {
                    case -1811142716:
                        if (p1.equals("kotlin.jvm.functions.Function10")) {
                            return "Function10";
                        } else {
                        }
                    case -1811142715:
                        if (p1.equals("kotlin.jvm.functions.Function11")) {
                            return "Function11";
                        } else {
                        }
                    case -1811142714:
                        if (p1.equals("kotlin.jvm.functions.Function12")) {
                            return "Function12";
                        } else {
                        }
                    case -1811142713:
                        if (p1.equals("kotlin.jvm.functions.Function13")) {
                            return "Function13";
                        } else {
                        }
                    case -1811142712:
                        if (p1.equals("kotlin.jvm.functions.Function14")) {
                            return "Function14";
                        } else {
                        }
                    case -1811142711:
                        if (p1.equals("kotlin.jvm.functions.Function15")) {
                            return "Function15";
                        } else {
                        }
                    case -1811142710:
                        if (p1.equals("kotlin.jvm.functions.Function16")) {
                            return "Function16";
                        } else {
                        }
                    case -1811142709:
                        if (p1.equals("kotlin.jvm.functions.Function17")) {
                            return "Function17";
                        } else {
                        }
                    case -1811142708:
                        if (p1.equals("kotlin.jvm.functions.Function18")) {
                            return "Function18";
                        } else {
                        }
                    case -1811142707:
                        if (p1.equals("kotlin.jvm.functions.Function19")) {
                            return "Function19";
                        } else {
                        }
                    default:
                        switch (v0_0) {
                            case -1811142685:
                                if (p1.equals("kotlin.jvm.functions.Function20")) {
                                    return "Function20";
                                } else {
                                }
                            case -1811142684:
                                if (p1.equals("kotlin.jvm.functions.Function21")) {
                                    return "Function21";
                                } else {
                                }
                            case -1811142683:
                                if (p1.equals("kotlin.jvm.functions.Function22")) {
                                    return "Function22";
                                } else {
                                }
                            default:
                                switch (v0_0) {
                                    case 80123371:
                                        if (p1.equals("kotlin.jvm.functions.Function0")) {
                                            return "Function0";
                                        } else {
                                        }
                                    case 80123372:
                                        if (p1.equals("kotlin.jvm.functions.Function1")) {
                                            return "Function1";
                                        } else {
                                        }
                                    case 80123373:
                                        if (p1.equals("kotlin.jvm.functions.Function2")) {
                                            return "Function2";
                                        } else {
                                        }
                                    case 80123374:
                                        if (p1.equals("kotlin.jvm.functions.Function3")) {
                                            return "Function3";
                                        } else {
                                        }
                                    case 80123375:
                                        if (p1.equals("kotlin.jvm.functions.Function4")) {
                                            return "Function4";
                                        } else {
                                        }
                                    case 80123376:
                                        if (p1.equals("kotlin.jvm.functions.Function5")) {
                                            return "Function5";
                                        } else {
                                        }
                                    case 80123377:
                                        if (p1.equals("kotlin.jvm.functions.Function6")) {
                                            return "Function6";
                                        } else {
                                        }
                                    case 80123378:
                                        if (p1.equals("kotlin.jvm.functions.Function7")) {
                                            return "Function7";
                                        } else {
                                        }
                                    case 80123379:
                                        if (p1.equals("kotlin.jvm.functions.Function8")) {
                                            return "Function8";
                                        } else {
                                        }
                                    case 80123380:
                                        if (p1.equals("kotlin.jvm.functions.Function9")) {
                                            return "Function9";
                                        } else {
                                        }
                                    default:
                                }
                        }
                }
        }
        return 0;
    }

    public static void g()
    {
        kotlin.KotlinNullPointerException v0_1 = new kotlin.KotlinNullPointerException();
        kotlin.jvm.internal.f.e(v0_1, kotlin.jvm.internal.f.getName());
        throw v0_1;
    }

    public static void h()
    {
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void i(String p2)
    {
        kotlin.UninitializedPropertyAccessException v0_2 = new kotlin.UninitializedPropertyAccessException(f0.a.d("lateinit property ", p2, " has not been initialized"));
        kotlin.jvm.internal.f.e(v0_2, kotlin.jvm.internal.f.getName());
        throw v0_2;
    }

    public static final Object[] j(java.util.Collection p4)
    {
        Object[] v0_0 = p4.size();
        if (v0_0 != null) {
            OutOfMemoryError v4_5 = p4.iterator();
            if (v4_5.hasNext()) {
                Object[] v0_1 = new Object[v0_0];
                int v1_6 = 0;
                while(true) {
                    int v2 = (v1_6 + 1);
                    v0_1[v1_6] = v4_5.next();
                    if (v2 < v0_1.length) {
                        if (!v4_5.hasNext()) {
                            break;
                        }
                    } else {
                        if (v4_5.hasNext()) {
                            int v1_5 = (((v2 * 3) + 1) >> 1);
                            if (v1_5 <= v2) {
                                v1_5 = 2147483645;
                                if (v2 >= 2147483645) {
                                    throw new OutOfMemoryError();
                                }
                            }
                            v0_1 = java.util.Arrays.copyOf(v0_1, v1_5);
                        } else {
                            return v0_1;
                        }
                    }
                    v1_6 = v2;
                }
                return java.util.Arrays.copyOf(v0_1, v2);
            }
        }
        return kotlin.jvm.internal.f.a;
    }

    public static final Object[] k(java.util.Collection p5, Object[] p6)
    {
        Object[] v0_0 = p5.size();
        int v2_2 = 0;
        if (v0_0 != null) {
            OutOfMemoryError v5_6 = p5.iterator();
            if (v5_6.hasNext()) {
                Object[] v0_2;
                if (v0_0 > p6.length) {
                    Object[] v0_1 = reflect.Array.newInstance(p6.getClass().getComponentType(), v0_0);
                    v0_1.getClass();
                    v0_2 = ((Object[]) v0_1);
                } else {
                    v0_2 = p6;
                }
                while(true) {
                    int v3_3 = (v2_2 + 1);
                    v0_2[v2_2] = v5_6.next();
                    if (v3_3 < v0_2.length) {
                        if (!v5_6.hasNext()) {
                            break;
                        }
                    } else {
                        if (v5_6.hasNext()) {
                            int v2_6 = (((v3_3 * 3) + 1) >> 1);
                            if (v2_6 <= v3_3) {
                                v2_6 = 2147483645;
                                if (v3_3 >= 2147483645) {
                                    throw new OutOfMemoryError();
                                }
                            }
                            v0_2 = java.util.Arrays.copyOf(v0_2, v2_6);
                        } else {
                            return v0_2;
                        }
                    }
                    v2_2 = v3_3;
                }
                if (v0_2 != p6) {
                    return java.util.Arrays.copyOf(v0_2, v3_3);
                } else {
                    p6[v3_3] = 0;
                    return p6;
                }
            } else {
                if (p6.length > 0) {
                    p6[0] = 0;
                }
            }
        } else {
            if (p6.length > 0) {
                p6[0] = 0;
                return p6;
            }
        }
        return p6;
    }
}
