import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Player {
    private final String name ;
    private final String team ;
    private final String role ;
    private final int matches ;
    private final int runs;
    private final int wickets;
    private final double average;
    private final double sr;

    Player(String name, String team, String role, int matches, int runs, int wickets, double average, double sr){
        this.name = name;
        this.team = team;
        this.role = role;
        this.matches = matches;
        this.runs = runs;
        this.wickets = wickets;
        this.average = average;
        this.sr = sr;
    }

    String getName() { return this.name; }
    String getTeam() { return this.team; }
    String getRole() { return this.role; }
    int getMatches() { return this.matches; }
    int getRuns() { return this.runs; }
    int getWickets() { return this.wickets; }
    double getAverage() { return this.average; }
    double getSr() { return this.sr; }

    int playerJudgementCriteria(){
        int playerPoints = runs + wickets*20;
        return playerPoints;
    }

    public String toString() {
        return  "Name : " + this.name + "\n"+
                "Team : " + this.team + "\n"+
                "Role : " + this.role + "\n"+
                "Matches : " + this.matches + "\n"+
                "Runs : " + this.runs + "\n"+
                "Wickets : " + this.wickets + "\n"+
                "Average : " + this.average + "\n"+
                "SR : " + this.sr + "\n";
    }
}

class IPL{
    int numberOfTeams;
    ArrayList<String> teams = null;
    ArrayList<String> homeGrounds = null;
    ArrayList<Player>playerPool = new ArrayList<Player>();

    IPL(){
        teams = new ArrayList<String>(Arrays.asList("RCB", "CSK", "PBKS", "SRH", "KKR", "RR", "DC", "MI"));
        homeGrounds = new ArrayList<String>(Arrays.asList(
                "M Chinnaswamy Stadium",
                "M. A. Chidambaram Stadium",
                "Punjab Cricket Association Cricket Stadium",
                "Rajiv Gandhi International Cricket Stadium, Hyderabad",
                "Eden Gardens",
                "Sawai Mansingh Stadium",
                "Arun Jaitley Stadium",
                "Wankhade Stadium"));

        numberOfTeams = 8;
    }

    void assignPlayer(Player player) {
        playerPool.add(player);
    }

    void createFixture() {
        int numDays = (numberOfTeams - 1); // Days needed to complete tournament
        int halfSize = numberOfTeams / 2;

        ArrayList<String> cloneTeams = new ArrayList<>(teams);
        cloneTeams.remove(0);

        int teamsSize = numberOfTeams-1;
        int day = 1;

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("IPL_fixtures.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        String columnNamesList = "Match Number, Team Home, Team Away, Ground";
        builder.append(columnNamesList + "\n");
        // No need give the headers Like: id, Name on builder.append
        if(pw != null) pw.write(builder.toString());
        else System.out.println("Cannot insert into file");


        for (int round = 0; round < numDays; round++) {
            int teamIdx = round % teamsSize;

            StringBuilder newFixture = new StringBuilder();
            newFixture.append(day+ ",");
            newFixture.append(cloneTeams.get(teamIdx) + ",");
            newFixture.append(teams.get(0) + ",");
            newFixture.append(homeGrounds.get(teamIdx) + "\n");
            pw.write(newFixture.toString());
            day++;
            for (int idx = 1; idx < halfSize; idx++) {
                int firstTeam = (round + idx) % teamsSize;
                int secondTeam = (round + teamsSize - idx) % teamsSize;

                newFixture.setLength(0);
                newFixture.append(day+ ",");
                newFixture.append(cloneTeams.get(firstTeam) + ",");
                newFixture.append(cloneTeams.get(secondTeam) + ",");
                newFixture.append(homeGrounds.get(firstTeam) + "\n");
                pw.write(newFixture.toString());
                day++;
            }
        }

        for (int round = 0; round < numDays; round++) {
            int teamIdx = round % teamsSize;

            StringBuilder newFixture = new StringBuilder();
            newFixture.append(day+ ",");
            newFixture.append(teams.get(0) + ",");
            newFixture.append(cloneTeams.get(teamIdx) + ",");
            newFixture.append(homeGrounds.get(0) + "\n");
            pw.write(newFixture.toString());
            day++;
            for (int idx = 1; idx < halfSize; idx++) {
                int firstTeam = (round + idx) % teamsSize;
                int secondTeam = (round + teamsSize - idx) % teamsSize;

                newFixture.setLength(0);
                newFixture.append(day+ ",");
                newFixture.append(cloneTeams.get(secondTeam) + ",");
                newFixture.append(cloneTeams.get(firstTeam) + ",");
                newFixture.append(homeGrounds.get(secondTeam) + "\n");
                pw.write(newFixture.toString());
                day++;
            }
        }

        pw.close();
    }

    void bestBowlers(String team){
        String queryTeam = team.toUpperCase();
        if(teams.contains(queryTeam)) {
            playerPool.stream()
                    .filter(player -> queryTeam.equals(player.getTeam()) && player.getWickets() >= 40 && player.getRole().equals("BOWLER"))
                    .forEach(System.out::println);
        } else {
            System.out.println("Team not found !");
        }

    }

    void searchPlayer(String queryPlayer) {
        int f = 0;
        Pattern pattern = Pattern.compile(queryPlayer, Pattern.CASE_INSENSITIVE);

        System.out.println("Searching for Players ... ");

        for(Player player : playerPool) {
            Matcher match = pattern.matcher(player.getName());
            while(match.find()) {
                f = 1;
                System.out.println(player);
            }
        }
        if(f == 0) System.out.println("Players Not Found !");
    }

    void highestWicketTaker(String team){
        String queryTeam = team.toUpperCase();
        if(teams.contains(queryTeam)) {
            Player playerHighestWicketTaker = playerPool.stream()
                                .filter(player -> queryTeam.equals(player.getTeam()))
                                .max(Comparator.comparingInt(Player :: getWickets))
                                .get();
            System.out.println("Highest Wicket Taker for "+queryTeam+" is :");
            System.out.println(playerHighestWicketTaker);
        } else {
            System.out.println("Team not found !");
        }
    }

    void highestRunScorer(String team){
        String queryTeam = team.toUpperCase();
        if(teams.contains(queryTeam)) {
            Player playerHighestRunScorer = playerPool.stream()
                    .filter(player -> queryTeam.equals(player.getTeam()))
                    .max(Comparator.comparingInt(Player :: getRuns))
                    .get();
            System.out.println("Highest Run Scorer for "+queryTeam+" is :");
            System.out.println(playerHighestRunScorer);
        } else {
            System.out.println("Team not found !");
        }
    }

    void getTopBowlers(){
        System.out.println("The top three Bowlers of IPL are");
        playerPool.stream().filter(player -> player.getRole().equals("BOWLER"))
                .sorted(Comparator.comparingInt(Player::getWickets).reversed())
                .limit(3)
                .forEach(System.out::println);
    }

    void getTopBatsman(){

        System.out.println("The top three Batsman of IPL are");
        playerPool.stream().filter(player -> player.getRole().equals("BATSMAN"))
                .sorted(Comparator.comparingInt(Player::getRuns).reversed())
                .limit(3)
                .forEach(System.out::println);
    }

    void getTopAllRounders(){
        System.out.println("Top 3 All Rounders of the Season are : ");
        playerPool.stream().filter(player -> player.getRole().equals("ALL ROUNDER"))
                .sorted(Comparator.comparingInt(Player::playerJudgementCriteria).reversed())
                .limit(3)
                .forEach(System.out::println);
    }

    void predictedScores(){
        System.out.println("Hypothetically the top two teams that will play the highest runs with 11 top batsman");
        Map<Double, String> treeMap = new TreeMap<>(new Comparator<Double>() {
            @Override
            public int compare(Double a, Double b) {
                return b.compareTo(a);
            }
        });
        for (String team : teams){
            String queryTeam = team.toUpperCase(Locale.ROOT);
            Double score = playerPool.stream()
                            .filter(player -> queryTeam.equals(player.getTeam()))
                            .sorted(Comparator.comparingDouble(Player::getAverage).reversed())
                            .limit(11)
                            .map(Player::getAverage)
                            .reduce(Double::sum).get();
            treeMap.put(score, team);
        }

        int i = 2;
        for(Map.Entry m:treeMap.entrySet()){
            if(i > 0)  System.out.println(m.getKey()+" "+m.getValue());
            else break;
            i--;
        }
    }

    void findNextGenPlayers(){
        System.out.println("The next Generation Players for each teams are :");
        for(String team : teams) {
            String queryTeam = team.toUpperCase(Locale.ROOT);
            playerPool.stream().filter(player -> player.getMatches() <= 20 && queryTeam.equals(player.getTeam()))
                    .sorted(Comparator.comparingDouble(Player::playerJudgementCriteria).reversed())
                    .limit(1)
                    .forEach(System.out::println);
        }
    }
}

class Solution {
    public static void main(String[] args) {
        IPL ipl = new IPL();

        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("IPL_2021_data.csv"));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] playerDetails = line.split(splitBy);
                Player newPlayer = new Player(playerDetails[0], playerDetails[1], playerDetails[2], Integer.parseInt(playerDetails[3]), Integer.parseInt(playerDetails[4]), Integer.parseInt(playerDetails[7]), Double.parseDouble(playerDetails[5]), Double.parseDouble(playerDetails[6]));
                ipl.assignPlayer(newPlayer);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);

        // Top Bowlers
        System.out.println("Enter the team : ");
        String team = sc.nextLine();
        ipl.bestBowlers(team);

        // Searching Feature
        System.out.println("Search Player : ");
        String queryPlayer = sc.nextLine();
        ipl.searchPlayer(queryPlayer);

        //Highest Wicket Taker and Highest Run Scorer
        System.out.println("Enter Team : ");
        String team1 = sc.nextLine();
        ipl.highestRunScorer(team1);
        ipl.highestWicketTaker(team1);

        //Top 3 bowlers
        ipl.getTopBowlers();

        //Top 3 batsman
        ipl.getTopBatsman();

        //Top 3 all rounders
        ipl.getTopAllRounders();

        //Get Hypotetical Match
        ipl.predictedScores();

        ipl.findNextGenPlayers();

        ipl.createFixture();
    }
}