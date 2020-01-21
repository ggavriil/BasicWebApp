package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("boaz")) {
            return "This is not the summer of 69. It's just 69.";
        }
	if(query.toLowerCase().contains("largest") && query.toLowerCase().contains("number")) {
		String[] parts = query.toLower().split(':');
		String[] parts2 = parts[1].split(',');
		int max = parts2.stream().map(Integer::valueOf).max(Integer::compare).get();
		return max.toString();
	}	
        return "";
    }
}
