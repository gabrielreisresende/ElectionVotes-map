package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Map<String, Integer> totalVotes = new TreeMap<>();

		System.out.print("Enter the full file path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {

				String[] fields = line.split(",");
				String candidate = fields[0];
				int newVotes = Integer.parseInt(fields[1]);

				if (totalVotes.containsKey(candidate)) {
					int votesSoFar = totalVotes.get(candidate);
					totalVotes.put(candidate, votesSoFar + newVotes);
				} else {
					totalVotes.put(candidate, newVotes);
				}

				line = br.readLine();
			}

			System.out.println();
			System.out.println("Total votes:");
			for (String key : totalVotes.keySet()) {
				System.out.println(key + ": " + totalVotes.get(key));
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			sc.close();
		}

	}

}
