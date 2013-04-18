package com.stonewall.web.util;

import java.text.Collator;
import java.util.Comparator;

import com.stonewall.web.model.FaqEntry;

public class SortFaq implements Comparator<FaqEntry> {

	private static Collator myCollator = Collator.getInstance();

	public int compare(FaqEntry o1, FaqEntry o2) {
		if (o1 != null && o2 != null) {
			return myCollator.compare(o1.getQuestion(), o2.getQuestion());
		}
		return -1;
	}
}
