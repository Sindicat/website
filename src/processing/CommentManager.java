package processing;

import dao.CommentsDAO;
import dao.CommentsEntity;

import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CommentManager {
    final static Logger logger = Logger.getLogger(CommentManager.class);
    public void addComment(String userName, String message) {
        logger.info("adding comment");
        Date date = new Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(date);

        CommentsEntity commentsEntity = new CommentsEntity();
        CustomersHash customers = new CustomersHash();
        commentsEntity.setCommentDate(currentTime);
        commentsEntity.setMessage(message);
        commentsEntity.setCustomerId(customers.getMap().get(userName));
        try {
            logger.info("adding comment go to DAO layer");
            CommentsDAO.addComment(commentsEntity);
            logger.info("adding comment go to DAO layer -> comment was successfully added!");
        } catch (SQLException e) {
            logger.error("ERROR! Something wrong with DAO layer");
            e.printStackTrace();
        }
    }
    public JSONObject getCommentsList(String customerID, int param){
        logger.info("Getting all comments and converting into JSON");
        CustomersHash customers = new CustomersHash();

        List<CommentsEntity> commentslist = (List<CommentsEntity>) CommentsDAO.getCommentsList(customers.getMap().get(customerID));
        JSONObject jsonObject = new JSONObject();
        if(param == 1){
            logger.info("Just last comment");
            JSONArray jsonArray = new JSONArray();
            CommentsEntity comment = commentslist.get(commentslist.size()-1);
            jsonArray.add(comment.getMessage());
            jsonArray.add(comment.getCommentDate());
            System.out.println(comment.getMessage());
            System.out.println(comment.getCommentDate());
            jsonObject.put("0", jsonArray);
            return jsonObject;
        }
        else if(param == 2){
            logger.info("All comments going to convert");
            jsonObject = new JSONObject();
            for (Integer i = 0; i < commentslist.size(); i++) {
                JSONArray jsonArray = new JSONArray();
                CommentsEntity comment = commentslist.get(i);
                jsonArray.add(comment.getMessage());
                jsonArray.add(comment.getCommentDate());
                jsonObject.put(i.toString(), jsonArray);
            }
            return jsonObject;
        }
        return null;
    }
}
