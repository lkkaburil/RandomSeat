package SoldeskFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SoldeskFrame extends JFrame {

private JPanel contentPane;
private JTextField txtn;
private JTextField textField_1;
private JTextField textField_2;
private JTextField textField_3;
private JTextField textField_4;
private JTextField textField_5;
private JTextField textField_6;
private JTextField textField_7;
private JTextField textField_8;
private JTextField textField_9;
private JTextField textField_10;
private JTextField textField_11;
private JTextField textField_12;
private JTextField textField_13;
private JTextField textField_14;
private JTextField textField_15;
private JTextField textField_16;
private JTextField textField_17;
private JTextField textField_18;
private JTextField textField_19;
private JTextField textField_20;
private JTextField textField_21;
private JTextField textField_22;
private JTextField textField_23;
private JTextField textField;

/**
 * 
 * Launch the application.
 * 
 */

public static void main(String[] args) {

EventQueue.invokeLater(() -> { // Runnable을 람다식으로 생략(인터페이스내 메소드가 한개라서 가능)
//	EventQueue 클래스는 시스템에서 발생하는 이벤트 를 Queue 형태로 관리해 준다. 
//	응용 프로그램 하나에는 이러한 EventQueue도 하나만 존재하게 된다. 
//	응용 프로그램에서 발생하는 모든 이벤트는, 
//	이벤트를 처리하는 쓰레드가 내부에 존재하여 처리 하고 있다.
// 	따라서 여기서는 메인쓰레드 + 이벤트 관리 쓰레드 2개가 존재한다.

try {

SoldeskFrame frame = new SoldeskFrame(); //메인메소드 진입하면 SoldeskFrame 객체를 생성한다.

frame.setVisible(true); 	//frame 객체에 선언되어있는 pane과 필드들이 보여지기 시작한다.

} catch (Exception e) {

e.printStackTrace();

}

});
}

/**
 * 
 * Create the frame.
 * 
 */

public SoldeskFrame() {

setTitle("\uC194\uB370\uC2A4\uD06C3\uAC15\uC758\uC2E4 \uC790\uB9AC\uBC30\uCE58\uD504\uB85C\uADF8\uB7A8");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 950, 910);
contentPane = new JPanel();
contentPane.setBackground(new Color(255, 228, 181));
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null); //앱솔루트 레이아웃(절대 위치로 화면을 구성함)

JButton start_btn = new JButton("\uC790\uB9AC\uBC30\uCE58 \uC2DC\uC791");
start_btn.addActionListener(new ActionListener() { //스타트 버튼에 액션리스너를 추가
   //액션리스너는 액션 발생을 감지함
   //매개변수로 새로운 액션리스너를 넣었는데
   //액션리스너는 인터페이스이므로 오버라이딩
   //해주어야한다(메소드가 한개이기때문에 람다식가능)

@SuppressWarnings("unchecked") // 검증되지 않은 연산자 관련 경고 억제
public void actionPerformed(ActionEvent e) { //액션이벤트가 감지되면 메소드가 실행된다.
try {
start_btn.setEnabled(false); //먼저 시작 버튼을 눌러지지 않도록 선언한다(계속 눌러지면 결과값이 누른만큼
 //바뀌면서 들어간다)(뒤에 사용한 Timer ?문에 서로 값이 겹쳐진다)
textField_1.setText(" ");//2번째 실행부터는 전의 실행 결과값을 없애기 위해 빈공간으로 자리를 초기화한다.
textField_2.setText(" ");
textField_3.setText(" ");
textField_4.setText(" ");
textField_5.setText(" ");
textField_6.setText(" ");
textField_7.setText(" ");
textField_8.setText(" ");
textField_9.setText(" ");
textField_10.setText(" ");
textField_11.setText(" ");
textField_12.setText(" ");
textField_13.setText(" ");
textField_14.setText(" ");
textField_15.setText(" ");
textField_16.setText(" ");
textField_17.setText(" ");
textField_18.setText(" ");
textField_19.setText(" ");
textField_20.setText(" ");
textField_21.setText(" ");
textField_22.setText(" ");
textField_23.setText(" ");

//	1.   getClass().getResource("gudaImage.jpg");
//	      현재 클래스의 위치에서 리소스를 찾는다
//	     클래스와 리소스의 위치가 같은 곳에 존재해야 한다.
//	    2.   getClass().getResource("/res/gudaImage.jpg");
//	     패키지와 동일 루트에서 검색
//	    3.   getClass().getClassLoader.getResource("res/gudaImage.jpg"); 
//	      패키지와 동일 루트에서의 상대 위치를 나타낸다.

InputStream in = this.getClass().getClassLoader().getResourceAsStream("soldesk3");
//현재 실행되어지는 클래스와 같은 디렉토리에서 soldesk3이라는 파일을 찾아내서 인풋스트림으로 읽어들인다.
//JAR 파일로 만들어서 사용하기위해서 사용
BufferedReader br = new BufferedReader(new InputStreamReader(in));
//인풋스트림으로 읽어들인 파일을 버퍼에 저장시켜 한줄식 읽기 위해 bufferedreader 객체를 생성한다.
TreeMap<String, Double> tm = new TreeMap<String, Double>();
//treemap의 자동 정렬 기능을 사용하기 위해 treemap 객체를 생성한다.

while (true) {

String name = br.readLine();
//파일에서 한줄을 읽어와서 지역변수 name에 초기화한다.
if (name == null) {
break;
//읽은 값이 없으면 와일문을 빠져나간다.

}

Double ran = Math.random(); // 업캐스팅(랜덤을 위해 난수를 발생시켜 wrapper타입 ran에 초기화한다

tm.put(name, ran);	//위에서 생성한 treemap 객체에 name 과 난수를 집어 넣는다.

}

br.close(); 
in.close();//더이상 읽을 것이 없으므로 br in 을 닫는다.


TreeSet<Object> set = new TreeSet<Object>(new Comparator<Object>() { 
//트리셋은 생성자의 매개변수 없이 만들면 자동정렬되는 set으로 가져오고
//기본 정렬값이 아닌 사용자정의로 정렬시키고 싶다면 새로운 Comparator 객체를 만들어야한다.
public int compare(Object obj, Object obj1) {
//Comparator 인터페이스를 구현하려면 compare 메소드를 재정의해야한다.
return ( ((Map.Entry<String, Double>) obj1).getValue())
//리턴값을 compareTo를 이용하여 맵의 value값을 비교해서 크면 양수 같으면 0 작으면 음수를 리턴받게한다.	
.compareTo(((Map.Entry<String, Double>) obj).getValue());

}//이터레이터로 반대로 뽑아내기위해(내림차순) 오름차순으로 저장시킨다.

});

set.addAll(tm.entrySet()); //위에서 만든 treeset에다가 treemap값을 저장하면 밸류값으로
   //비교를 해서 위에 정의한 사용자 정의방식으로 정렬시킨다.
   

int j = 0;

String[] str = new String[set.size()]; //이터레이터를 돌려서 스트링형 배열에 담기위해
   //treeset size만큼의 스트링형배열을 만든다.

for (Iterator<Object> i = set.iterator(); i.hasNext(); j++) { 
//for문 초기조건으로 treeset이터레이터 객체 생성후, 이터레이터가 읽을값이 있을동안 for문을 돌리면서
Map.Entry<String, Double> entry = (Map.Entry<String, Double>) i.next();
//Map.entry를 이용해 Object타입의 읽어온 데이터를 다시 Map형식으로 바꿔준다
str[j] = (String) entry.getKey();//키값을 꺼내서 순서대로 스트링형 배열에 캐스팅후 넣어준다.

System.out.println("배정 받은번호" + (j + 1) + "번" + str[j] + ":" + entry.getValue());
//누구에게 어떤 난수가 갔는지 확인하기위한 콘솔창 출력문.
}
//여기까지만 해도 랜덤한 자리로 자리배치가능


JTextField[] tf = new JTextField[23]; //자리를 순서대로가 아닌 무작위로 넣기 위해 
  //이름이 들어가게될 텍스트필드배열을
  //인원수만큼 생성 후 순서대로 초기화한다.

tf[0] = textField_1;	//리팩토링해야함(더 짧고 간결하게 초기화할수있는 방법생각해봐야함)
tf[1] = textField_2;	
tf[2] = textField_3;
tf[3] = textField_4;
tf[4] = textField_5;
tf[5] = textField_6;
tf[6] = textField_7;
tf[7] = textField_8;
tf[8] = textField_9;
tf[9] = textField_10;
tf[10] = textField_11;
tf[11] = textField_12;
tf[12] = textField_13;
tf[13] = textField_14;
tf[14] = textField_15;
tf[15] = textField_16;
tf[16] = textField_17;
tf[17] = textField_18;
tf[18] = textField_19;
tf[19] = textField_20;
tf[20] = textField_21;
tf[21] = textField_22;
tf[22] = textField_23;

Timer m_timer = new Timer(); //자리를 순서대로 시간 간격을 두고 넣기위해 타이머 객체 생성

TimerTask m_task1 = new TimerTask() { //시간 간격 때마다 할일을 정해주기위한
  //Runnable인터페이스를 구현한 타이머태스크추상클래스
  //객체를 생성하며 오버라이딩함.
  //Runnable을 구현하였으므로  이 일을 전담하는
  //새로운 쓰레드를 생성함

int a = 0;
int[] numArr = new int[23];	//인트형 배열을 인원수만큼 생성후

public void randd() { //자리를 섞는 메소드를 생성.

for (int i = 0; i < numArr.length; i++) {

// for문을 이용하여 배열을 0~23까지 차례로 초기화 시켜준다.

numArr[i] = i;

}//여기까지는 numArr배열의 값의 순서가 오름차순임.

for (int i = 0; i < 871125; i++) {

int n = (int) (Math.random() * 23); //0<=x<23까지의 값을 난수생성하여
//0~22까지의 인트형 숫자값을 랜덤하게
//뽑아냄
int temp = numArr[0];	//원래 인덱스 0에 있는 값을 temp에 저장
numArr[0] = numArr[n];	            //랜덤하게 뽑아낸 숫자의 인덱스 방에 있는
//값을 첫번째 방에 넣어줌
numArr[n] = temp;	//넣어준 방에는 첫번째 방 값이 들어감
   //따라서 첫번째 방과 랜덤하게 선택된 방의 값을 바꿔준다.
       //이것을 충분히 큰 숫자로 돌리게 되면 랜덤성을 가질수 있다.

}
}

public void run() {

if (a == 0) { //위에 선언한 필드 인트형 a값의 처음값인 0일때 배열의 값을 섞어준다.

randd();

}

if (a < 23) { //이후 a의 값을 1씩늘리면서 배열인덱스가 22가 될?까지

tf[numArr[a]].setText(str[a]); 
//0~22까지 인덱스를 가진 난수에 의해 정렬된 str배열을 0~22번 자리가 섞여서 값이
//들어있는 numArr[a] 값번째 자리에 텍스트 필드에 초기화 시킨다.

a++;//저장을 한번하면 필드 a의 값을 1더한다. else로 넘어가지 않고 task를 끝낸다.

} else {

m_timer.cancel();

JOptionPane.showMessageDialog(null, "자리 배치가 완료되었습니다 확인하세요!");
start_btn.setEnabled(true);

}

}

};

m_timer.schedule(m_task1, 2000, 2000);//m_Timertask 스레드가 시작됨
//타이머에 선언되어있는 스케쥴 메소드를 이용해 처음시작시 2초후부터 2초간격씩 넣다가 a값이 23이되면 
//if else 문에 의해 m_timer가 종료되면서 자리배치 완료 알림창이 뜨고 다시 시작 버튼이 활성화 된다.

}

catch (Exception e1) {

// TODO Auto-generated catch block

e1.printStackTrace();

}
//메소드를 따로 빼서 사용하지도 않았고 에러처리또한 한번에 Exception 처리를 해버렸기
//때문에 디버깅시 어려움이 많았다.
//객체 지향적 프로그래밍을 위해서는 구조부터 다시 생각하고 프로그래밍해야할 것같다.

}

});

start_btn.setBounds(380, 760, 171, 86);
contentPane.add(start_btn);
txtn = new JTextField(); //JTextField 객체 생성
txtn.setFont(new Font("굴림", Font.PLAIN, 25));//폰트지정
txtn.setForeground(new Color(255, 255, 255)); //폰트색 설정
txtn.setHorizontalAlignment(SwingConstants.CENTER); //가로정렬 하는 메소드
txtn.setText("\uC194\uB370\uC2A4\uD06C 3\uAC15\uC758\uC2E4 \uCE60\uD310"); //텍스트필드에 텍스트 지정
txtn.setBackground(new Color(0, 100, 0)); //텍스트필드배경색깔설정
txtn.setEditable(false); //텍스트필드에 텍스트입력불가 선언
txtn.setBounds(12, 21, 910, 94); //텍스트필드 위치선언
contentPane.add(txtn); //txtn이라는 텍스트필드를 contePane에 추가
txtn.setColumns(10);	//텍스트파일 가로길이 설정

textField_1 = new JTextField();
textField_1.setFont(new Font("굴림", Font.PLAIN, 25));
textField_1.setHorizontalAlignment(SwingConstants.CENTER);
textField_1.setBackground(new Color(218, 165, 32));
textField_1.setEditable(false);
textField_1.setBounds(34, 298, 108, 69);
contentPane.add(textField_1);
textField_1.setColumns(10);

textField_2 = new JTextField();
textField_2.setFont(new Font("굴림", Font.PLAIN, 25));
textField_2.setHorizontalAlignment(SwingConstants.CENTER);
textField_2.setEditable(false);
textField_2.setColumns(10);
textField_2.setBackground(new Color(218, 165, 32));
textField_2.setBounds(154, 298, 108, 69);
contentPane.add(textField_2);

textField_3 = new JTextField();
textField_3.setFont(new Font("굴림", Font.PLAIN, 25));
textField_3.setHorizontalAlignment(SwingConstants.CENTER);
textField_3.setEditable(false);
textField_3.setColumns(10);
textField_3.setBackground(new Color(218, 165, 32));
textField_3.setBounds(274, 298, 108, 69);
contentPane.add(textField_3);

textField_4 = new JTextField();
textField_4.setFont(new Font("굴림", Font.PLAIN, 25));
textField_4.setHorizontalAlignment(SwingConstants.CENTER);
textField_4.setEditable(false);
textField_4.setColumns(10);
textField_4.setBackground(new Color(218, 165, 32));
textField_4.setBounds(561, 298, 108, 69);
contentPane.add(textField_4);
textField_5 = new JTextField();

textField_5.setFont(new Font("굴림", Font.PLAIN, 25));
textField_5.setHorizontalAlignment(SwingConstants.CENTER);
textField_5.setEditable(false);
textField_5.setColumns(10);
textField_5.setBackground(new Color(218, 165, 32));
textField_5.setBounds(681, 298, 108, 69);
contentPane.add(textField_5);

textField_6 = new JTextField();
textField_6.setFont(new Font("굴림", Font.PLAIN, 25));
textField_6.setHorizontalAlignment(SwingConstants.CENTER);
textField_6.setEditable(false);
textField_6.setColumns(10);
textField_6.setBackground(new Color(218, 165, 32));
textField_6.setBounds(801, 298, 108, 69);
contentPane.add(textField_6);

textField_7 = new JTextField();
textField_7.setFont(new Font("굴림", Font.PLAIN, 25));
textField_7.setHorizontalAlignment(SwingConstants.CENTER);
textField_7.setEditable(false);
textField_7.setColumns(10);
textField_7.setBackground(new Color(218, 165, 32));
textField_7.setBounds(12, 413, 108, 69);
contentPane.add(textField_7);

textField_8 = new JTextField();
textField_8.setFont(new Font("굴림", Font.PLAIN, 25));
textField_8.setHorizontalAlignment(SwingConstants.CENTER);
textField_8.setEditable(false);
textField_8.setColumns(10);
textField_8.setBackground(new Color(218, 165, 32));
textField_8.setBounds(125, 413, 108, 69);
contentPane.add(textField_8);

textField_9 = new JTextField();
textField_9.setFont(new Font("굴림", Font.PLAIN, 25));
textField_9.setHorizontalAlignment(SwingConstants.CENTER);
textField_9.setEditable(false);
textField_9.setColumns(10);
textField_9.setBackground(new Color(218, 165, 32));
textField_9.setBounds(237, 413, 108, 69);
contentPane.add(textField_9);

textField_10 = new JTextField();
textField_10.setFont(new Font("굴림", Font.PLAIN, 25));
textField_10.setHorizontalAlignment(SwingConstants.CENTER);
textField_10.setEditable(false);
textField_10.setColumns(10);
textField_10.setBackground(new Color(218, 165, 32));
textField_10.setBounds(349, 413, 108, 69);
contentPane.add(textField_10);

textField_11 = new JTextField();
textField_11.setFont(new Font("굴림", Font.PLAIN, 25));
textField_11.setHorizontalAlignment(SwingConstants.CENTER);
textField_11.setEditable(false);
textField_11.setColumns(10);
textField_11.setBackground(new Color(218, 165, 32));
textField_11.setBounds(561, 413, 108, 69);
contentPane.add(textField_11);

textField_12 = new JTextField();
textField_12.setFont(new Font("굴림", Font.PLAIN, 25));
textField_12.setHorizontalAlignment(SwingConstants.CENTER);
textField_12.setEditable(false);
textField_12.setColumns(10);
textField_12.setBackground(new Color(218, 165, 32));
textField_12.setBounds(681, 413, 108, 69);
contentPane.add(textField_12);

textField_13 = new JTextField();
textField_13.setFont(new Font("굴림", Font.PLAIN, 25));
textField_13.setHorizontalAlignment(SwingConstants.CENTER);
textField_13.setEditable(false);
textField_13.setColumns(10);
textField_13.setBackground(new Color(218, 165, 32));
textField_13.setBounds(801, 413, 108, 69);
contentPane.add(textField_13);

textField_14 = new JTextField();
textField_14.setFont(new Font("굴림", Font.PLAIN, 25));
textField_14.setHorizontalAlignment(SwingConstants.CENTER);
textField_14.setEditable(false);
textField_14.setColumns(10);
textField_14.setBackground(new Color(218, 165, 32));
textField_14.setBounds(12, 533, 108, 69);
contentPane.add(textField_14);

textField_15 = new JTextField();
textField_15.setFont(new Font("굴림", Font.PLAIN, 25));
textField_15.setHorizontalAlignment(SwingConstants.CENTER);
textField_15.setEditable(false);
textField_15.setColumns(10);
textField_15.setBackground(new Color(218, 165, 32));
textField_15.setBounds(125, 533, 108, 69);
contentPane.add(textField_15);

textField_16 = new JTextField();
textField_16.setFont(new Font("굴림", Font.PLAIN, 25));
textField_16.setHorizontalAlignment(SwingConstants.CENTER);
textField_16.setEditable(false);
textField_16.setColumns(10);
textField_16.setBackground(new Color(218, 165, 32));
textField_16.setBounds(237, 533, 108, 69);
contentPane.add(textField_16);

textField_17 = new JTextField();
textField_17.setFont(new Font("굴림", Font.PLAIN, 25));
textField_17.setHorizontalAlignment(SwingConstants.CENTER);
textField_17.setEditable(false);
textField_17.setColumns(10);
textField_17.setBackground(new Color(218, 165, 32));
textField_17.setBounds(349, 533, 108, 69);
contentPane.add(textField_17);

textField_18 = new JTextField();
textField_18.setFont(new Font("굴림", Font.PLAIN, 25));
textField_18.setHorizontalAlignment(SwingConstants.CENTER);
textField_18.setEditable(false);
textField_18.setColumns(10);
textField_18.setBackground(new Color(218, 165, 32));
textField_18.setBounds(561, 533, 108, 69);
contentPane.add(textField_18);

textField_19 = new JTextField();
textField_19.setFont(new Font("굴림", Font.PLAIN, 25));
textField_19.setHorizontalAlignment(SwingConstants.CENTER);
textField_19.setEditable(false);
textField_19.setColumns(10);
textField_19.setBackground(new Color(218, 165, 32));
textField_19.setBounds(681, 533, 108, 69);
contentPane.add(textField_19);

textField_20 = new JTextField();
textField_20.setFont(new Font("굴림", Font.PLAIN, 25));
textField_20.setHorizontalAlignment(SwingConstants.CENTER);
textField_20.setEditable(false);
textField_20.setColumns(10);
textField_20.setBackground(new Color(218, 165, 32));
textField_20.setBounds(801, 533, 108, 69);
contentPane.add(textField_20);

textField_21 = new JTextField();
textField_21.setFont(new Font("굴림", Font.PLAIN, 25));
textField_21.setHorizontalAlignment(SwingConstants.CENTER);
textField_21.setEditable(false);
textField_21.setColumns(10);
textField_21.setBackground(new Color(218, 165, 32));
textField_21.setBounds(125, 644, 108, 69);
contentPane.add(textField_21);

textField_22 = new JTextField();
textField_22.setFont(new Font("굴림", Font.PLAIN, 25));
textField_22.setHorizontalAlignment(SwingConstants.CENTER);
textField_22.setEditable(false);
textField_22.setColumns(10);
textField_22.setBackground(new Color(218, 165, 32));
textField_22.setBounds(237, 644, 108, 69);
contentPane.add(textField_22);

textField_23 = new JTextField();
textField_23.setFont(new Font("굴림", Font.PLAIN, 25));
textField_23.setHorizontalAlignment(SwingConstants.CENTER);
textField_23.setEditable(false);
textField_23.setColumns(10);
textField_23.setBackground(new Color(218, 165, 32));
textField_23.setBounds(349, 644, 108, 69);
contentPane.add(textField_23);

textField = new JTextField();
textField.setText("\uC548\uD61C\uC815\uC120\uC0DD\uB2D8");
textField.setHorizontalAlignment(SwingConstants.CENTER);
textField.setFont(new Font("굴림", Font.PLAIN, 25));
textField.setEditable(false);
textField.setColumns(10);
textField.setBackground(new Color(218, 165, 32));
textField.setBounds(612, 187, 297, 69);
contentPane.add(textField);

}

}