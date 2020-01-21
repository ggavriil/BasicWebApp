package com.develogical;

import java.util.Arrays;
import java.util.regex.Pattern;

public class QueryProcessor {

    private int getFib(int n) {
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        return getFib(n - 1) + getFib(n - 2);
    }

    public String process(String query) {
        Pattern fibRegex = Pattern.compile("(.)what is the (\\d)+th number in the fibonacci sequence(.*)");
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("boaz")) {
            return "This is not the summer of 69. It's just 69.";
        }
	    if(query.toLowerCase().contains("largest") && query.toLowerCase().contains("number")) {
		    String[] parts = query.toLowerCase().split(":");
		    String[] parts2 = parts[2].split(",");
		    Integer max = Arrays.stream(parts2).map(Integer::valueOf).max(Integer::compare).get();
		    return max.toString();
	    }
	    if(fibRegex.matcher(query.toLowerCase()).matches()) {
            int n = Integer.valueOf(fibRegex.matcher(query.toLowerCase()).group(1));
            return String.valueOf(getFib(n));
        }
        return "";
    }
}
