package page275;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.*;

public class aa {

        public static class Node {
            int cpct;
            int now;

            public Node(int cpct, int now) {
                this.cpct = cpct;
                this.now = now;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Node node = (Node) o;
                return cpct == node.cpct && now == node.now;
            }

            @Override
            public int hashCode() {
                return Objects.hash(cpct, now);
            }
        }

        public static void main(String[] args) {
            // Node 배열 생성
            List<Node> list1 = new ArrayList<Node>(List.of(new Node(1, 2), new Node(3, 4)));
            List<Node> list2= new ArrayList<Node>(List.of(new Node(1, 2), new Node(3, 4)));
            List<Node> list3 = new ArrayList<Node>(List.of(new Node(5, 6), new Node(7, 8)));

            // HashSet에 Node 배열 추가
            Set<List<Node>> set = new HashSet<>();
            set.add(list1);
            set.add(list2);
            set.add(list3);

            // 필드가 모두 같은 배열은 중복으로 취급되지 않음
            System.out.println("Set size: " + set.size()); // Set은 중복을 허용하지 않으므로 크기는 2

            // 동일한 배열이 있는지 확인
            System.out.println("Contains array1: " + set.contains(list1)); // true
            System.out.println("Contains array2: " + set.contains(list2)); // true
            System.out.println("Contains array3: " + set.contains(list3)); // true
        }
    }







