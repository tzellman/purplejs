package io.purplejs.core.resource;

import java.io.File;

final class FileResourceLoader
    implements ResourceLoader
{
    private final File dir;

    FileResourceLoader( final File dir )
    {
        this.dir = dir;
    }

    @Override
    public Resource loadOrNull( final ResourcePath path )
    {
        final File file = new File( this.dir, path.getPath() );
        if ( !file.isFile() )
        {
            return null;
        }

        return new FileResource( path, file );
    }
}