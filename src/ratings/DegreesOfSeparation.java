package ratings;

import ratings.datastructures.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DegreesOfSeparation {

    private ArrayList<Movie> masterMovieList;

    private Graph<String> graph = new Graph<>();

    public DegreesOfSeparation(ArrayList<Movie> movies) {
        this.masterMovieList = movies;
        loadMovies(this.masterMovieList);
    }

    public  int degreesOfSeparation(String cast, String cast2) {
        int degrees = 0;
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        Queue<String> queue = new LinkedList();
        for (String member : this.graph.getAdjacencyList().keySet()){
            map.put(member, new ArrayList<>());
            map.get(member).add(-1);
        }

        if (!(map.containsKey(cast) && map.containsKey(cast2)))
        {
            return -1;
        }

        map.get(cast).set(0,0);

        queue.add(cast);

        while (!(queue.isEmpty()))
        {
            String cast_member = queue.remove();
            for (String neightbors : graph.getNeighbors(cast_member))
            {
                if (map.get(neightbors).get(0) == -1)
                {
                    map.get(neightbors).set(0, map.get(cast_member).get(0) + 1);
                    queue.add(neightbors);
                }

            }

            System.out.println(queue);
        }

        return map.get(cast2).get(0);
    }

    public Graph<String> getGraph()
    {
        return this.graph;
    }
    public void loadMovies(ArrayList<Movie> mov)
    {
        for (Movie movie : mov)
        {
            ArrayList<String> cast_list = movie.getCast();
            for(String cast_1 : cast_list)
            {
                for(String cast_2 :cast_list)
                {
                    if (!(graph.areConnected(cast_1, cast_2)) && !(graph.areConnected(cast_2, cast_1)) && !(cast_1.equals(cast_2)))
                    {
                        graph.addBidirectionalEdge(cast_1, cast_2);
                    }
                }
            }
        }
    }

}





