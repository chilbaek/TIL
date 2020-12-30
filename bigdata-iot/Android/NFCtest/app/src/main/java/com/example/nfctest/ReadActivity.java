package com.example.nfctest;

import java.util.List;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nfctest.nfc.NdefMessageParser;
import com.example.nfctest.nfc.ParsedRecord;
import com.example.nfctest.nfc.TextRecord;
import com.example.nfctest.nfc.UriRecord;

public class ReadActivity extends ActionBarActivity {
    TextView readResult;

    private NfcAdapter mAdapter;
    private PendingIntent mPendingIntent;
    private IntentFilter[] mFilters;
    private String[][] mTechLists;
    private Tag tag;
    private IsoDep tagcomm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        readResult = (TextView) findViewById(R.id.readResult);

        /**
         * NFC를 다루는 도구를 생성 해준다.

         */
        mAdapter = NfcAdapter.getDefaultAdapter(this);

        /**
         * 만약 앱이 현재화면에 보인다면, 이화면에서 nfc 작업을 한다.
         */
        Intent targetIntent = new Intent(this, ReadActivity.class);
        targetIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        /**
         * 인텐트의 임무를 pendingIntent에게 전달한다.
         */
        mPendingIntent = PendingIntent.getActivity(this, 0, targetIntent, 0);


        /**
         만약 NFC태그를 성공적으로 읽었으면,

         NFC태그에 전원이 공급된 순간 데이터와 함께, ACTION_NDEF_DISCOVERED 인텐트에 정보를 캡슐화해서 단말기에

         넘겨준다.  그러므로 ACTION_NDEF_DISCOVERED를 받아들일 준비를 할수있게, IntentFilter에 추가해준다.   */
        IntentFilter ndef = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);

        /**
         * 모든 데이터 타입을 받아들인다.
         */
        try {
            ndef.addDataType("*/*");
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException("fail", e);
        }

        /**
         * 필터배열에 받을 인텐트의 필터를 장착한다.
         */
        mFilters = new IntentFilter[] { ndef };


        /**
         * 어떠한 기술을 쓸지 정의해준다.
         */
        mTechLists = new String[][] { new String[] { NfcA.class.getName() } };
    }


    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        if (mAdapter != null) {

/**

 * 현재 앱이 화면에 보일때, nfc를 등록해준다.

 인자:FLAG_ACTIVITY_SINGLE_TOP , ACTION_NDEF_DISCOVERED , NfcA

 */
            mAdapter.enableForegroundDispatch(this, mPendingIntent, mFilters,
                    mTechLists);
        }
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();

        if (mAdapter != null) {
            mAdapter.disableForegroundDispatch(this);
        }
    }

    /**
     * 데이터를 성공적으로 읽었으면, NFC 태그에있는 내용을 INTENT로 캡슐화 해서 받아온다.

     *이게 동작하는 이유는 우리가 onResume에서 현재 앱에서 nfc처리를 해준다는 내용과,

     *nfc태그에 대한 정보를 받을 인텐트필터를 등록해줬기때문이다.
     */
    public void onNewIntent(Intent passedIntent) {
        // 받아온 인텐트에서 NFC 태그를 가져온다.
        Tag tag = passedIntent.getParcelableExtra(NfcAdapter.EXTRA_TAG);

        if (tag != null) {

/**

 tag.getId();를 하면 tag아이디를 byte형식으로 뽑아올수있다.

 이것을 toHexString 즉 , 16진수로 변환하여, 영어 코드로 가져온다.

 **/
            byte[] tagId = tag.getId();
            readResult.append("태그 ID : " + toHexString(tagId) + "\n");
        }
        if (passedIntent != null) {
            processTag(passedIntent);
        }

    }


    // NFC 태그 ID를 리턴하는 메소드
    public static final String CHARS = "0123456789ABCDEF";

    public static String toHexString(byte[] data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {


/**

 data[i]의 숫자를 >>4 즉 , 16을(2의 4승)나눠줍니다.

 거기다가 0x0f = 00001111의 이진수를 &연산자로 나온값을

 문자형으로 바꿔줍니다.

 */
            sb.append(CHARS.charAt((data[i] >> 4) & 0x0f)).append(
                    CHARS.charAt(data[i] & 0x0f));
        }
        return sb.toString();
    }



    // onNewIntent 안에서 tagID를 가져오고나서, TAG의 내용을 가져오기 위한 메소드
    private void processTag(Intent passedIntent) {
        Parcelable[] rawMsgs = passedIntent
                .getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);

        // 받아온 메시지가 없으면 그냥 리턴해준다.
        if (rawMsgs == null) {
            return;
        }

        Toast.makeText(getApplicationContext(), "스캔 성공!", 1000).show();

        NdefMessage[] msgs;





        // 받아온 INTENT에 압축된 태그내용을 NdefMessage형식으로 포맷해준다.
        if (rawMsgs != null) {
            msgs = new NdefMessage[rawMsgs.length];
            for (int i = 0; i < rawMsgs.length; i++) {
                msgs[i] = (NdefMessage) rawMsgs[i];
                /**
                 * tag의 내용을 가져오는 역할을 하는 메소드
                 */
                showTag(msgs[i]);
            }
        }  }



    // NFC 태그 정보를 읽어들이는 메소드
    private int showTag(NdefMessage mMessage) {
        /**
         * NDEFMESSAGE안에잇는 레코드 정보들 parse라는 메소드로 분석해서 레코드를 뽑아온다.
         */
        List<ParsedRecord> records = NdefMessageParser.parse(mMessage);
        final int size = records.size();

        /**
         * 레코드 사이즈만큼 해당하는 태그를 뽑아온다.
         */
        for (int i = 0; i < size; i++) {
            ParsedRecord record = records.get(i);

            /**
             * 레코드에 해당하는 타입
             */
            int recordType = record.getType();

            String recordStr = "";
            if (recordType == ParsedRecord.TYPE_TEXT) {
                recordStr = "TEXT:" + ((TextRecord) record).getText();
            } else if (recordType == ParsedRecord.TYPE_URI) {
                recordStr = "URI :" + ((UriRecord) record).getUri().toString();
            }
            // 읽어들인 텍스트 값을 TextView에 붙인다.
            readResult.append(recordStr + "\n");
        }
        return size;
    }
}


