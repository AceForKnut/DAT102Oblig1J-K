package timeTest;

import java.time.Duration;
import java.time.Instant;

public class Test3 {
	
	public int funksjon1(int a){
		int ut = a + a;                                 // En elementær operasjon (?)
		return ut;                                      // En EO (?)
	}
	
	
	public int funksjon2(int a){
		int ut = a + a;                                 // En EO (?)
		ut = ut + a;                                    // En EO (?)
		ut = ut + a;                                    // En EO (?)
		return ut;                                      // En EO (?)
	}
	
	public int funksjon3(int a){
		int x = funksjon1(a);                                 // En EO + Antall EO i funksjon1 
		int y = funksjon2(x) + funksjon1(a);                  // En EO (?) + Antall EO i funksjon2 
		int sum = 0;                                          // En EO
		for(int i = 0; i< 10; i++) {                          // Repeter 10 ganger:
			sum = sum + 1;                                    // En EO (?)
		}
		int ut = y + sum;                                     // En EO
		return ut;                                            // En EO (?)
	}
	
	public int funksjon4(int[] tab, int i) {
		int ut = tab[i];                                      // En EO
		return ut;                                            // En EO
	}
	
	////////////////////////////////////////////////////////////////
	
	public int funksjon5(int[] tab) {
		int sum = 0;
		for(int i = 0; i < tab.length; i++) {
			sum += tab[i];
		}
		return sum;
	}
	
	public int funksjon6(int[] tab) {
		int sum = 0;
		for(int i = 0; i < tab.length; i++) {
			sum *= tab[i];
		}
		return sum;
	}

	public int funksjon7(int[] tab) {
		int maxIndeks = 0;
		for(int i = 0; i < tab.length; i++) {
			boolean iErMax = true;
			for(int j = 0; j < tab.length; j++) {
				if (tab[i] < tab[j]) {
					iErMax = false;
				}
			}
			if( iErMax ) {
				maxIndeks = i;
			}
		}
		return maxIndeks;
	}
	
	public int funksjon8(int[] tab) {
		int maxIndeks = 0;
		for(int i = 0; i < tab.length; i++) {
			if(tab[maxIndeks] < tab[i]) {
				maxIndeks = i;
			}
		}
		return maxIndeks;
	}
	
	///////////////////////////////////////
	
	public int funksjon9(int n) {
		int step = 0;
		for(int i = 0; i < n; i++) {
			step++;
		}
		return step;
	}
	
	public int funksjon10(int n) {
		int step = 0;
		for(int i = 0; i < n*2; i++) {
			step++;
		}
		return step;
	}

	
	public int funksjon11(int n) {
		int step = 0;
		for(int i = 0; i < n; i = i+5) {
			step++;
		}
		return step;
	}
	
	public int funksjon12(int n) {
		int step = 0;
		for(int i = 0; i < n*n; i++) {
			step++;
		}
		return step;
	}
	
	public int funksjon13(int n) {
		int step = 0;
		for(int i = 0; i*i < n; i++) {
			step++;
		}
		return step;
	}
	
	
	public int funksjon14(int n) {
		int step = 0;
		for(int i = 1; i < n; i = i*2) {
			step++;
		}
		return step;
	}
	
	public int funksjon15(int n) {
		int step = 0;
		for(int i = n; i > 1; i = i/2) {
			step++;
		}
		return step;
	}
	
	
	public int funksjon16(int n) {
		int step = 0;
		
		for(int i = 0; i < n; i++) {
			step++;
		}
		
		for(int i = 0; i*i < n; i++) {
			step++;
		}
		
		return step;
	}
		
	public int funksjon17(int n) {
		int step = 0;
		for(int i = 1; i < n; i = i*2) {
			step++;
		}
		
		for(int i = n; i > 1; i = i/2) {
			step++;
		}
		
		for(int i = 0; i < n*n; i++) {
			step++;
		}		
		return step;
	}
	
	
	/////////////////////////////////
	
	public int funksjon18(int n) {
		
		int step = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {
				step++;
			}
		}
		
		return step;
	}
	
	public int funksjon19(int n) {
		
		int step = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				step++;
			}
		}
		
		return step;
	}
	
	public int funksjon20(int n) {
		
		int step = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				for(int k = j; k < n; k++) {
					step++;
				}
			}
		}
		
		return step;
	}
	
	public int funksjon21(int n) {
		
		int step = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {
				step++;
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				step++;
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				for(int k = j; k < n; k++) {
					step++;
				}
			}
		}
		
		for(int i = 0; i < n*n; i++) {
			for(int j = i; j < n*n; j++) {
				step++;
			}
		}
		
		return step;
	}
	
	public boolean funksjon22(int tab[], int target) {
		int n = tab.length;
		// Genererer alle undermengder av tabellen (bit magi)
        for (int i = 0; i < (1 << n); i++) {
            int sum = 0;
            boolean[] currentSubset = new boolean[n];

            // Lager en boolsk tabell som representerer en gitt undermengde
            for (int j = 0; j < n; j++) {
                currentSubset[j] = (i % 2) == 1;
                i /= 2;
            }

            // Regner ut summen av tallene for hver undermengde
            for (int j = 0; j < n; j++) {
                if (currentSubset[j]) {
                    sum += tab[j];
                }
            }

            // Ser om vi oppnådde målsummen vår
            if (sum == target) {
                return true;
            }
        }

        return false;
		
	}



	
	
	
	public static void main(String[] args) {
		Instant start = Instant.now(); 
		
		
		
		
		Instant end = Instant.now(); // Record the end time
        Duration duration = Duration.between(start, end); // Calculate the duration
        System.out.println("\nTime taken: " + duration.toMillis() + " milliseconds");
	}

}
