package InterviewPractice2020.AllOtherCodingProblems;
import java.util.*;

public class FindMovieOnFlight {
//
//	public static void findMovies(int[] list, int target) {
//List<Integer>  lis = new ArrayList<>();
//Map<indexes, Integer>  map = new LinkedHashMap<>();
//	for (int   li : list){
//		lis.add(li);
//	}
//      Arrays.sort(list);
//      int fin = target - 30;
//      int res = 0;
//      int result =0;
//
//      for (int i= 0; i < list.length; i++){
//      	res = fin - list[i];
//      	for(int j  = i+1; j < list.length; j++){
//      		if(list[j] <= res){
//      			result = list[i] + list[j];
//      			int lisIndI = lis.indexOf(list[i]);
//      			//lis.set(lisIndI, -1	);
//      			int lisIndJ = list[i] == list[j] ? lis.lastIndexOf(list[j]) : lis.indexOf(list[j]);
//      			map.put(new indexes(lisIndI, lisIndJ), result);
//			}else{
//      			//break;
//			}
//		}
//
//	  }
//		Iterator<Map.Entry<indexes, Integer>> it = map.entrySet().iterator();
//
//      while(it.hasNext()){
//      Map.Entry<indexes, Integer>	itt = it.next();
//        if(itt.getValue().equals(Collections.max(map.values()))){
//			  System.out.println("Found: " + itt.getKey().getInd1() + " , " + itt.getKey().getInd2() + " >> " + itt.getValue());
//			  break;
//		  }
//	  }
//
//	}
//
//	public static void main(String[] args) {
//
//	findMovies(new int[]{90, 85, 75, 60, 120, 150, 125}, 250);
//	findMovies(new int[]{90, 85, 75, 60, 155, 150, 125}, 250);
//    findMovies(new int[]{90, 85, 75, 60, 120, 110, 110, 150, 125}, 250);
//	findMovies(new int[]{95, 85, 75, 60, 120, 110, 110, 150, 125}, 250);
//    findMovies(new int[]{1, 10, 25, 35, 60}, 90);
//    findMovies(new int[]{20, 50, 40, 25, 30, 10}, 90);
//	findMovies(new int[]{5, 55, 40, 20, 30, 30}, 90);
//
//	}
//}
//
//class indexes{
//	private int ind1;
//	private int ind2;
//	indexes(int ind1, int ind2){
//		this.ind1 = ind1;
//		this.ind2 = ind2;
//	}
//	public int getInd1(){
//		return ind1;
//	}
//	public int getInd2(){
//		return ind2;
//	}
//
//}

		public static List<Integer> findMovies(int[] list, int target) {
			target -= 30;
			List<Integer> ans = new ArrayList<>();
			ans.add(-1);
			ans.add(-1);

			// Sort the movies by length
			int[][] movies = new int[list.length][2];
			for(int i = 0; i < list.length; i++) {
				movies[i][0] = list[i]; // Movie duration
				movies[i][1] = i;       // Original index of the movie
			}
			// We use the (a, b) -> a[0] - b[0] only when we sort 2d array
			Arrays.sort(movies, (a, b) -> a[0] - b[0]);

			// Two pointer: shrink from begin/end
			int l = 0, r = list.length -1;
			int max = 0;
			while(l < r) {
				if(movies[l][0] + movies[r][0] > target) {
					r--;
				} else {
					if(movies[l][0] + movies[r][0] > max) {
						max = movies[l][0] + movies[r][0];
						ans.set(0, movies[l][1]);
						ans.set(1, movies[r][1]);
					}
					l++;
				}
			}

			return ans;
		}

		public static void main(String[] args) {
			System.out.println(findMovies(new int[]{90, 85, 75, 60, 120, 150, 125}, 250));
			System.out.println(findMovies(new int[]{90, 85, 75, 60, 155, 150, 125}, 250));
			System.out.println(findMovies(new int[]{90, 85, 75, 60, 120, 110, 110, 150, 125}, 250));
			System.out.println(findMovies(new int[]{95, 85, 75, 60, 120, 110, 110, 150, 125}, 250));
			System.out.println(findMovies(new int[]{1, 10, 25, 35, 60}, 90));
			System.out.println(findMovies(new int[]{20, 50, 40, 25, 30, 10}, 90));
			System.out.println(findMovies(new int[]{5, 55, 40, 20, 30, 30}, 90));
		}
	}
