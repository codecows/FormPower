package app.temp.pojo;

import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel("菜单所属系统")
public class MenuScenePojo {
    private String sceneId;
    private String sceneName;
    private String status;
    private List<MenuGroupPojo> menuGroups;

    public List<MenuGroupPojo> getMenuGroups() {
        return menuGroups;
    }

    public void setMenuGroups(List<MenuGroupPojo> menuGroups) {
        this.menuGroups = menuGroups;
    }

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
