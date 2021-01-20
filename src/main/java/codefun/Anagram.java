package codefun;

public class Anagram {

	public static void main(String[] args) {

		int a = 'a';
		int z = 'z';
		System.out.println(a + " -- " + z);

		System.out.println(isAnagram("cat", "rac"));
		System.out.println(isAnagram("car", "rac"));
	}

	public static boolean isAnagram(String s, String t) {
		boolean isAnagram = true;

		int[] arr = new int[26];
		for(int i = 0; i<s.length(); i++)
			arr[s.charAt(i) - 'a']++;

		for(int i = 0; i< t.length(); i++)
			arr[t.charAt(i) - 'a']--;

		for(int i = 0; i<26; i++)
		{
			if(arr[i] != 0) {
				isAnagram = false;
				break;
			}
		}
		return isAnagram;
	}

}
