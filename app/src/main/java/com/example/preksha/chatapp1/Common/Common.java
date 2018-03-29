package com.example.preksha.chatapp1.Common;

import com.example.preksha.chatapp1.Holder.QBUsersHolder;
import com.quickblox.users.model.QBUser;

import java.util.List;
import java.util.Queue;

/**
 * Created by PREKSHA on 28-12-2017.
 */

public class Common {

    public static final String DIALOG_EXTRA = "Dialogs";

    public static String createChatDialogName(List<Integer> qbUsers)
    {
        List<QBUser> qbUsers1 = QBUsersHolder.getInstance().getUsersByIds(qbUsers);
        StringBuilder name = new StringBuilder();

        for (QBUser user:qbUsers1)
            name.append(user.getFullName()).append(" ");
        if (name.length()>30)
        {
            name = name.replace(30,name.length()-1, "...");
        }
        return name.toString();
    }

    public static boolean isNullOrEmptyString (String content)
    {
        return (content != null && !content.trim().isEmpty() ? false:true );

    }


}
