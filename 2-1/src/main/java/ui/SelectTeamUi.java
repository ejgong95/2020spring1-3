package ui;

import java.util.List;

import dao.TeamDao;
import model.Team;

public class SelectTeamUi extends AbstractUi {
	private TeamDao teamDao;

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	protected void showTeamList(List<Team> teamList) {
		System.out.println("=========================");
		System.out.println("팀 번호	팀 이름");
		for (Team team : teamList) {
			System.out.printf("%d	%s \n", team.getTeam_id(), team.getName());
		}
	}

	public void show() {
		try {
			showTeamList(this.teamDao.getTeamList());
		} catch (Exception e) {
			System.out.println("Enter키를 누르세요.");
			this.getInputedString();
		}
	}

}
