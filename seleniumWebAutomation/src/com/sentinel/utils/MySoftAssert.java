package com.sentinel.utils;

import java.util.Arrays;
import java.util.Map;

import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;
import org.testng.collections.Maps;

public class MySoftAssert extends SoftAssert{
	private final Map<AssertionError, IAssert<?>> m_errors = Maps.newLinkedHashMap();
	
	@Override
	protected void doAssert(IAssert<?> a) {
		System.out.println("doAssert Class Name:" + a.getClass());
		onBeforeAssert(a);
        try {
            a.doAssert();
            onAssertSuccess(a);
        } catch (AssertionError ex) {
            onAssertFailure(a, ex);
            m_errors.put(ex, a);
        } finally {
            onAfterAssert(a);
        }
	}
	
		
	@Override
	public void assertAll() {
		if (! m_errors.isEmpty()) {
            StringBuilder sb = new StringBuilder("The following asserts failed:");
            boolean first = true;
            for (Map.Entry<AssertionError, IAssert<?>> ae : m_errors.entrySet()) {
                if (first) {
                    first = false;
                } else {
                    sb.append(",");
                }
//                sb.append("\n\t");
//                sb.append(ae.getKey().getMessage());
                sb.append("\n\nStack Trace :\n");
                sb.append(Arrays.toString(ae.getKey().getStackTrace()).replaceAll(",", "\n"));
            }
            throw new AssertionError(sb.toString());
        }

	}
}
