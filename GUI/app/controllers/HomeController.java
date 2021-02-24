package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.libs.Json;
import play.mvc.Controller;

import play.mvc.Result;
import services.ForBackend;
import utils.Response;

import static services.ForBackend.*;

public class HomeController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger("controller");

    public Result viewAllClubs(){
        ForBackend.sortingByPoints();
        logger.debug("In HomeController.view(), result is: {}",clubLeagueList.toString());
        return ok(Json.toJson(clubLeagueList));
    }

    public Result viewAllClubsWithWinsComparator(){
        ForBackend.winsComparing();
        logger.debug("In HomeController.view(), result is: {}",clubLeagueList.toString());
        return ok(Json.toJson(clubLeagueList));
    }

    public Result viewAllClubsWithGoalsComparator(){
        ForBackend.goalsComparing();
        logger.debug("In HomeController.view(), result is: {}",clubLeagueList.toString());
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(clubLeagueList, JsonNode.class);
        System.out.println(clubLeagueList.toString());
        return ok(Json.toJson(clubLeagueList));
    }

    public Result viewAllClubsWithPointsComparator(){
        ForBackend.sortingByPoints();
        logger.debug("In HomeController.view(), result is: {}",clubLeagueList.toString());
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(clubLeagueList, JsonNode.class);
        System.out.println(clubLeagueList.toString());
        return ok(Json.toJson(clubLeagueList));
    }

    public Result viewMatches(){
        ForBackend.dateComparingForMatches();
        logger.debug("In HomeController.view(), result is: {}",matchesList.toString());
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(matchesList, JsonNode.class);
        System.out.println(matchesList.toString());
        return ok(Json.toJson(matchesList));
    }

    public Result viewRandomMatch(){

        logger.debug("In HomeController.view(), result is: {}",matchesList.toString());

        return ok(Json.toJson(ForBackend.addRandomMatches()));
    }

    public Result viewSearchMatch(String date){
        ForBackend.searchMatch(date);

        return ok(Json.toJson(searchedMatches));

    }

}
