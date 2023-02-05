import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// Classe Votante
class Voter {

  private String name;
  private String id;
  private int vote = -1;

  public Voter(String name, String id) {

    this.name = name;
    this.id = id;

  }

  public String getName() {

    return name;
    
  }

  public String getId() {

    return id;

  }

  public int getVote() {

    return vote;

  }

  public void setVote(int vote) {

    this.vote = vote;

  }
}

// Classe Candidato
class Candidate {

  private int number;
  private String name;
  private String party;
  private int votes = 0;

  public Candidate(int number, String name, String party) {

    this.number = number;
    this.name = name;
    this.party = party;

  }

  public int getNumber() {

    return number;

  }

  public String getName() {

    return name;

  }

  public String getParty() {

    return party;

  }

  public int getVotes() {

    return votes;

  }

  public void addVote() {

    votes++;

  }
}

// Classe Poll (eleicao)
class Poll {

  private ArrayList<Voter> voters;
  private ArrayList<Candidate> candidates;

  public Poll(ArrayList<Voter> voters, ArrayList<Candidate> candidates) {

    this.voters = voters;
    this.candidates = candidates;

  }

  public void displayOptions() {

    System.out.println("Opcoes de candidatos: ");

    for (Candidate candidate : candidates) {

      System.out.println(candidate.getNumber() + ". " + candidate.getName() + " (" + candidate.getParty() + ")");

    }

  }

  public void castVote(Voter voter) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Votante " + voter.getName() + " do ID " + voter.getId() + ": Digite o seu voto: ");
    int vote = sc.nextInt();

    voter.setVote(vote);
    candidates.get(vote - 1).addVote();

  }

  public void displayResults() {

    System.out.println("Resultados: ");

    for (Candidate candidate : candidates) {

      System.out.println(candidate.getName() + " (" + candidate.getParty() + ") teve " + candidate.getVotes() + " votos.");

    }

  }

  public void writeResultsToFile(String fileName) throws IOException {

    FileWriter writer = new FileWriter(fileName);

    for (Candidate candidate : candidates) {

      writer.write(candidate.getName() + "," + candidate.getParty() + "," + candidate.getVotes() + "\n");

    }

    writer.close();

  }

}

// Classe Principal
public class Urna {

  public static void main (String[] args) throws IOException {

    ArrayList<Voter> voters = new ArrayList<>();
    voters.add(new Voter("Jheickson Felipe", "12345"));
    voters.add(new Voter("Amiraldo Ferreira", "67890"));

    ArrayList<Candidate> candidates = new ArrayList<>();
    candidates.add(new Candidate(1, "Abraham", "IEG"));
    candidates.add(new Candidate(2, "Lincoln", "GEI"));

    Poll poll = new Poll(voters, candidates);
    poll.displayOptions();

    for (Voter voter : voters) {

      poll.castVote(voter);

    }

    poll.displayResults();
    poll.writeResultsToFile("Projeto/resultados.csv");

  }

}