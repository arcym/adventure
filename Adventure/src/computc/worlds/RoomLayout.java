package computc.worlds;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import computc.entities.Thug;

public class RoomLayout
{
	private int[][] tiles = new int[Room.getTileyWidth()][Room.getTileyHeight()];
	
	public RoomLayout(String path)
	{
		try
		{
			Document document = new SAXBuilder().build(path);
			
			List<Element> tilelayer = document.getRootElement().getChild("layer").getChild("data").getChildren();
			List<Element> objectgroup = document.getRootElement().getChild("objectgroup").getChildren();
			
			for(int tx = 0; tx < Room.getTileyWidth(); tx++)
			{
				for(int ty = 0; ty < Room.getTileyHeight(); ty++)
				{
					Element element = tilelayer.get(ty * Room.getTileyWidth() + tx);
					this.tiles[tx][ty] = element.getAttribute("gid").getIntValue();
				}
			}
			
			for(Element element : objectgroup)
			{
				if(element.getAttribute("gid").getIntValue() == 4)
				{
					int x = element.getAttribute("x").getIntValue() + (48 / 2);
					int y = element.getAttribute("y").getIntValue() - (48 / 2);
					
					//this.dungeon.entities.add(new Thug(this.dungeon, this, x, y));
				}
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
}