package com.stonewall.web.mock;

import com.stonewall.web.util.ResourceUtils;

public class MockResourceUtils implements ResourceUtils {

	public String getPictureDirectory() {
		return System.getProperty("java.io.tmpdir") + "/resources/pictures/";
	}

}
