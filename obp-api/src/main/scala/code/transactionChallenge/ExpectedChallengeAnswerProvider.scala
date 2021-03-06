package code.transactionChallenge


import net.liftweb.common.Box


trait ExpectedChallengeAnswerProvider {
  def saveExpectedChallengeAnswer(challengeId: String,
                                  transactionRequestId: String,
                                  salt: String,
                                  expectedAnswer: String, 
                                  expectedUserId: String): Box[ExpectedChallengeAnswer]
  def getExpectedChallengeAnswer(challengeId: String): Box[ExpectedChallengeAnswer]
  
  /**
    * There is another method:  Connector.validateChallengeAnswer, it validate the challenge over Kafka.
    * This method, will validate the answer in OBP side. 
    */
  def validateChallengeAnswerInOBPSide(challengeId: String, challengeAnswer: String, userId: Option[String]) : Box[Boolean] 
}



class RemotedataExpectedChallengeAnswerProviderCaseClasses {
  case class saveExpectedChallengeAnswer(challengeId: String, transactionRequestId: String, salt: String, expectedAnswer: String, expectedUserId: String)
  case class getExpectedChallengeAnswer(challengeId: String)
  case class validateChallengeAnswerInOBPSide(challengeId: String, challengeAnswer: String, userId: Option[String])
}

object RemotedataExpectedChallengeAnswerProviderCaseClasses extends RemotedataExpectedChallengeAnswerProviderCaseClasses


