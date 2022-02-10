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
        	answer = ""; // ���� ��ܾ�
        	sum = 0; //�ִ� ����
        	count = 0; //ã�� �ܾ� ��
            for(int j = 0 ; j < 4; j++) {
            	String s = br.readLine();
            	for(int k = 0 ; k < 4 ; k++) {
            		map[j][k] = s.charAt(k);
            	}
            }
            for (int k = 0; k < 4; k++) {
                for (int j = 0; j < 4; j++) {
                    //��� ���� ���� -> root�� �ش� child�� ������
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
		//1. üũ��
		visited[y][x] = true;
		sb.append(map[y][x]);
		//2. �������� �����ߴ°� - �ܾ��� ���̸鼭, ù��° �湮�� �� 
		if(node.isEnd && !node.isHit) {
			node.isHit = true; //ù��° �湮 üũ
			sum += score[length]; //�ܾ� ���� üũ
			count++; //�ܾ� ī��Ʈ ����
			String foundWord = sb.toString(); //���� �ܾ� 
			//ã�� �ܾ��� ���̰� �� ũ�ٸ� ������ ��, ���ٸ� ������
			if(compare(answer,foundWord) > 0) {
				answer = foundWord;
			}
		}
		//3. ����� �� ��ȸ - 8��
		for(int i = 0 ; i < 8 ;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
		    //  4. �����Ѱ�? map�� ���, �湮���� ����, node�� �ش� �ڽ��� ����
			if(ny >= 0 && ny < 4 && nx >= 0 && nx < 4) {
				if(!visited[ny][nx] && node.hasChild(map[ny][nx])) {
					//  5. �湮
					search(ny,nx,length+1,node.getChild(map[ny][nx]));
				}
			}
		}
		//6. üũ�ƿ� - ���� ��Ҹ� üũ�� �� visted�� sb�� �����ؾ��ϹǷ�
		visited[y][x] = false;
		sb.deleteCharAt(length-1);
		
	}
    static void insertNode(String word) {
    	Node cur = root;
    	for(int i = 0; i < word.length(); i++) {
    		//���� child�� ���ٸ�
    		//child�� �ش��ϴ� �ε����� ���ο� ��� ����
    		if(!cur.hasChild(word.charAt(i))) { 
    			cur.child[word.charAt(i)-'A'] = new Node();
    		}
    		//�ְų� ���ų� �ڽ����� �̵�
    		cur = cur.getChild(word.charAt(i));
    	}
    	//������ ���� ������ �ǹ�
    	cur.isEnd = true;
    }
	static class Node {
		Node[] child = new Node[26];
		boolean isEnd; // �ܾ��� ��
		boolean isHit; // �ܾ� ó������ ã���� ��

		boolean hasChild(char c) {
			return child[c - 'A'] != null;
		}

		Node getChild(char c) {
			return child[c - 'A'];
		}

		// ���� ������ �Ѿ ��
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
