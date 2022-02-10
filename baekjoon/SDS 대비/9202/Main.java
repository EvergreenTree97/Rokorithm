package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int dx[] = { 1, 1, 1, 0, -1, -1, -1, 0 };
	static int dy[] = { 1, 0, -1, -1, -1, 0, 1, 1 };
	static int score[] = { 0, 0, 0, 1, 1, 2, 3, 5, 11 };
	static boolean[][] visited;
	static char[][] map;
	static String answer;
	static int w, sum, count;
	static StringBuilder sb = new StringBuilder();
	static Node root = new Node();

	public static void main(String[] args) throws IOException {
		System.setIn(
				new FileInputStream("C:\\Users\\evergreen\\eclipse-workspace\\baekjoon\\src\\baekjoon\\input.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		w = Integer.parseInt(br.readLine());
        for (int i = 0; i < w; i++) {
            insertNode(br.readLine());
        }
        br.readLine();
        int b = Integer.parseInt(br.readLine());
        StringBuilder resSb = new StringBuilder();
        for(int i = 0 ; i < b ;i++) {
        	map = new char[4][4];
        	visited = new boolean[4][4];
        	answer = ""; // 가장 긴단어
        	sum = 0; //최대 점수
        	count = 0; //찾은 단어 수
            for(int j = 0 ; j < 4; j++) {
            	String s = br.readLine();
            	for(int k = 0 ; k < 4 ; k++) {
            		map[j][k] = s.charAt(k);
            	}
            }
            for (int k = 0; k < 4; k++) {
                for (int j = 0; j < 4; j++) {
                    //출발 가능 조건 -> root가 해당 child를 가지면
                    if(root.hasChild(map[k][j])){
                        search(k,j,1,root.getChild(map[k][j]));
                    }

                }
            }
            resSb.append(sum).append(" ").append(answer).append(" ").append(count).append("\n");
            root.clearHit();
            br.readLine();
        }
        bw.write(resSb.toString());
        bw.flush();
        bw.close();
	}
	static int compare(String s1, String s2){
		int result = Integer.compare(s2.length(), s1.length());
		if(result == 0) return s1.compareTo(s2);
		else {
			return result;
		}
	}
	static void search(int y, int x, int length, Node node){
		//1. 체크인
		visited[y][x] = true;
		sb.append(map[y][x]);
		//2. 목적지에 도달했는가 - 단어의 끝이면서, 첫번째 방문일 때 
		if(node.isEnd && !node.isHit) {
			node.isHit = true; //첫번째 방문 체크
			sum += score[length]; //단어 점수 체크
			count++; //단어 카운트 증가
			String foundWord = sb.toString(); //현재 단어 
			//찾은 단어의 길이가 더 크다면 정답이 됨, 같다면 사전순
			if(compare(answer,foundWord) > 0) {
				answer = foundWord;
			}
		}
		//3. 연결된 곳 순회 - 8방
		for(int i = 0 ; i < 8 ;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
		    //  4. 가능한가? map의 경계, 방문하지 않음, node가 해당 자식을 가짐
			if(ny >= 0 && ny < 4 && nx >= 0 && nx < 4) {
				if(!visited[ny][nx] && node.hasChild(map[ny][nx])) {
					//  5. 방문
					search(ny,nx,length+1,node.getChild(map[ny][nx]));
				}
			}
		}
		//6. 체크아웃 - 다음 요소를 체크할 때 visted와 sb를 재사용해야하므로
		visited[y][x] = false;
		sb.deleteCharAt(length-1);
		
	}
    static void insertNode(String word) {
    	Node cur = root;
    	for(int i = 0; i < word.length(); i++) {
    		//만약 child가 없다면
    		//child에 해당하는 인덱스에 새로운 노드 생성
    		if(!cur.hasChild(word.charAt(i))) { 
    			cur.child[word.charAt(i)-'A'] = new Node();
    		}
    		//있거나 없거나 자식으로 이동
    		cur = cur.getChild(word.charAt(i));
    	}
    	//마지막 노드는 끝임을 의미
    	cur.isEnd = true;
    }
	static class Node {
		Node[] child = new Node[26];
		boolean isEnd; // 단어의 끝
		boolean isHit; // 단어 처음으로 찾았을 때

		boolean hasChild(char c) {
			return child[c - 'A'] != null;
		}

		Node getChild(char c) {
			return child[c - 'A'];
		}

		// 다음 맵으로 넘어갈 때
		void clearHit() {
			isHit = false;
			for (int i = 0; i < child.length; i++) {
				Node children = child[i];
				if (children != null) {
					children.clearHit();
				}
			}
		}
	}
}
