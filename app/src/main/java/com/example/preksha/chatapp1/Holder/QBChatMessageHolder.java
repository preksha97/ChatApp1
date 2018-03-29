package com.example.preksha.chatapp1.Holder;

import com.quickblox.chat.model.QBChatMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by PREKSHA on 28-12-2017.
 */

public class QBChatMessageHolder {

    private static QBChatMessageHolder instance;
    private HashMap<String,ArrayList<QBChatMessage>> qbChatMessageArray;

    public static synchronized QBChatMessageHolder getInstance()
    {
        QBChatMessageHolder qbChatMessageHolder;
        synchronized (QBChatMessageHolder.class){
            if (instance==null)
                instance = new QBChatMessageHolder();
            qbChatMessageHolder = instance;
        }
        return qbChatMessageHolder;
    }
    private  QBChatMessageHolder()
    {
        this.qbChatMessageArray = new HashMap<>();

    }

    public void putMessage(String dialogId,ArrayList<QBChatMessage>qbChatMessages)
    {
        this.qbChatMessageArray.put(dialogId,qbChatMessages);
    }
    public void putMessage(String dialogId,QBChatMessage qbChatMessage)
    {
        List<QBChatMessage> lstResult= (List)this.qbChatMessageArray.get(dialogId);
        lstResult.add(qbChatMessage);
        ArrayList<QBChatMessage> lstAdded= new ArrayList(lstResult.size());
        lstAdded.addAll(lstResult);
        putMessage(dialogId,lstAdded);
    }

    public ArrayList<QBChatMessage> getChatMessagesByDialogId(String dialogId) {
        return (ArrayList<QBChatMessage>)this.qbChatMessageArray.get(dialogId);
    }


}
